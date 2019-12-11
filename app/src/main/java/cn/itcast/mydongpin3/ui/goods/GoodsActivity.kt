package cn.itcast.mydongpin3.ui.goods

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.shop.ShopActivity
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.activity_goods_detail.*

class GoodsActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)
        initBanner()
        ivBack.setOnClickListener(this)
        tvLike.setOnClickListener(this)
        llGotoShop.setOnClickListener(this)
        tvShare.setOnClickListener(this)
    }

    fun initBanner(){
        val DofuImage = arrayListOf<Int>(R.drawable.dofu1 ,R.drawable.dofu2 , R.drawable.dofu3 )
        val DofuTitle = arrayListOf<String>( "1/3" ,"2/3" ,"3/3")
        banGoods.setImages(DofuImage)
        banGoods.setDelayTime(3000)
        banGoods.isAutoPlay(true)
        banGoods.setBannerTitles(DofuTitle)
        banGoods.setImageLoader( object :ImageLoader(){
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                imageView?.setImageResource(path as Int)
            }
        })

        banGoods.setIndicatorGravity(BannerConfig.CENTER)
        banGoods.setBannerAnimation(Transformer.Default)
        banGoods.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        banGoods.start()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack ->{
                finish()
            }
            R.id.tvLike -> {
                Toast.makeText(this , "您未认证，请先认证再\n进行相关操作",Toast.LENGTH_SHORT).show()
            }
            R.id.llGotoShop -> {
                val intent = Intent()
                intent.setClass(this, ShopActivity::class.java)
                startActivity(intent)
            }
            R.id.tvShare -> {

            }
        }
    }
}
