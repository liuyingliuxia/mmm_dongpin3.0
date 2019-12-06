package cn.itcast.mydongpin3.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.frozen.FrozenFragment
import cn.itcast.mydongpin3.ui.main.news.NewsFragment
import cn.itcast.mydongpin3.ui.main.work.WorkFragment
import com.google.android.material.appbar.AppBarLayout
import com.sotia.mydongpin.ui.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.in_toolbar_open.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mStack = Stack <Fragment> ()
    private val mFrozenFragment by lazy { FrozenFragment() }
    private val mNewsFragment by lazy { NewsFragment () }
    private val mWorkFragment by lazy { WorkFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //clickEvent()
        initFragment()
        changeFragment(0)

        llSearch.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, SearchActivity::class.java)
            startActivity(intent)

        }

    }

    private fun initFragment () {

        val manager = supportFragmentManager.beginTransaction()
        manager.add (R.id.mContaier,mFrozenFragment)
        manager.add (R.id.mContaier,mNewsFragment)
        manager.add (R.id.mContaier,mWorkFragment)
        manager.commit()

        mStack.add(mFrozenFragment)
        mStack.add(mNewsFragment)
        mStack.add(mWorkFragment)


    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment )
        }

        manager.show(mStack[position])
        manager.commit()
    }

   /* fun clickEvent() {
    app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener(){
            appBarLayout: AppBarLayout, i: Int ->

        fun onOffsetChanged( appBarLayout:AppBarLayout, verticalOffset :Int) {
            //垂直方向偏移量
            val offset :Int = Math.abs( verticalOffset )
            //最大偏移距离
            val scrollRange = appBarLayout.getTotalScrollRange();
            if (offset <= scrollRange / 2) {
                in_toolbar_open.setVisibility(View.VISIBLE);
                in_toolbar_close.setVisibility(View.GONE);

            } else {
                in_toolbar_close.setVisibility(View.VISIBLE)
                in_toolbar_open.setVisibility(View.GONE)

            }
        }
    })
}*/
}

