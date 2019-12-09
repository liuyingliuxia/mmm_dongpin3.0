package cn.itcast.mydongpin3.ui.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

import cn.itcast.mydongpin3.R;

/**
 * author : zhengz
 * time   : 2018/1/15
 * desc   :
 */

public class BezierView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private PorterDuffXfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.XOR);

    private WeakReference<Bitmap> mSrcRect;

    private Path mDstPath = new Path();

    private float mOffsetValue;


    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint.setStyle(Paint.Style.FILL);
    }

    /**
     * 创建遮罩层
     *
     * @return
     */
    private Bitmap makeSrcRect(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        bitmap.eraseColor(getResources().getColor(R.color.color1));
        return bitmap;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int saveCount = canvas.save();

        final float value = mOffsetValue;

//        if (null == mDstCircle) {
//            mDstCircle = makeDstCircle(width, height);
//        }


//        float x0 = 0;
//        float y0 = 0;
//
//        float x1 = 0;
//        float y1 = (height) * (1 - value);
//
//        float x2 = width + width/4;
//        float y2 = (height) * (1 - value);
//
//        float x3 = width;
//        float y3 = 0;
//
//
//        mDstPath.reset();
//        mDstPath.moveTo(x0, y0);
//        mDstPath.cubicTo(x1, y1, x2, y2, x3, y3);
//        mDstPath.close();

        float x0 = 0;
        float y0 = 0;

        float x1 = width / 2;
        float y1 = (height) * (1 - value);

        float x2 = width;
        float y2 = 0;


        mDstPath.reset();
        mDstPath.moveTo(x0, y0);
        mDstPath.quadTo(x1, y1, x2, y2);
        mDstPath.close();


        // 绘制Dst
        canvas.drawPath(mDstPath, mPaint);

        mPaint.setXfermode(mXfermode);
        // 绘制Src

        if (null == mSrcRect || null == mSrcRect.get()) {
            Bitmap bitmap = makeSrcRect(width, height);
            if (null != bitmap) {
                mSrcRect = new WeakReference(bitmap);
            }
        }

        if (null != mSrcRect && null != mSrcRect.get()) {
            canvas.drawBitmap(mSrcRect.get(), 0, 0, mPaint);
        }
        mPaint.setXfermode(null);

        canvas.restoreToCount(saveCount);
    }


    public void setValue(float value) {
        if (value > 1f) {
            value = 1f;
        }
        if (value != mOffsetValue) {
            mOffsetValue = value;
            invalidate();
        }
    }


}
