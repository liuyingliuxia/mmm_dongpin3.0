package cn.itcast.mydongpin3.ui.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.chat.ChatActivity
import cn.itcast.mydongpin3.ui.main.drawer.IdentityAuthActivity
import cn.itcast.mydongpin3.ui.main.drawer.PersonInforActicity
import cn.itcast.mydongpin3.ui.main.drawer.SettingActivity
import cn.itcast.mydongpin3.ui.main.frozen.MallFragment
import cn.itcast.mydongpin3.ui.main.news.NewsFragment
import cn.itcast.mydongpin3.ui.main.work.WorkFragment
import cn.itcast.mydongpin3.ui.talk.TalkActivity
import cn.itcast.mydongpin3.ui.toolbox.ToolBoxActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sotia.mydongpin.ui.scan.ScanActivity
import com.sotia.mydongpin.ui.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.in_open_title.*
import kotlinx.android.synthetic.main.in_toolbar_open.*
import java.util.*
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.in_toolbar_close.*
import kotlinx.android.synthetic.main.in_toolbar_open.ivScan
import kotlinx.android.synthetic.main.in_toolbar_open.ivToolBarMyCenter

class MainActivity : AppCompatActivity(),View.OnClickListener,BottomNavigationView.OnNavigationItemSelectedListener{

    private val mStack = Stack <Fragment> ()
    private val mFrozenFragment by lazy { MallFragment() }
    private val mNewsFragment by lazy { NewsFragment () }
    private val mWorkFragment by lazy { WorkFragment() }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initFragment()
        changeFragment(0)
        flContentSearch.setOnClickListener (this)
        llFrozen.setOnClickListener (this)
        llNews.setOnClickListener (this)
        llWork.setOnClickListener (this)
        tvMall2.setOnClickListener (this)
        tvNews2.setOnClickListener (this)
        tvWork2.setOnClickListener (this)

        ivScan.setOnClickListener (this)

        tvNavIdentity.setOnClickListener(this)
        tvNavPerson.setOnClickListener(this)
        tvNavSetting.setOnClickListener(this)

        //DrawerLayout 抽屉拉出的点击事件
        ivToolBarMyCenter.setOnClickListener (this)

        //底部导航栏item的点击事件
        bnvMain.setOnNavigationItemSelectedListener(this)

        //下拉刷新 和 向下滑动的手势冲突,要下拉到顶部才刷新
       // srlMain.setOnRefreshListener (this)

        onOffsetChanged()

    }

    //上划事件监听
    private fun onOffsetChanged () {
        val toolbarHeight = this.resources.getDimension(R.dimen.mmm_avatar_size_default)
        appBar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener{
            override fun onOffsetChanged(appBarLayout : AppBarLayout?, verticalOffset : Int) {
//                flToolBarSearch.alpha = 0.toFloat()
//                llCloseHide.visibility = View.VISIBLE
//                llToolbarClose.visibility = View.GONE
                //垂直方向偏移量取绝对值
                var offset = Math.abs(verticalOffset)
                //最大偏移距离
                var scrollRange :Double = appBarLayout?.totalScrollRange!!.toDouble()

                if (offset <= scrollRange?.div(2) ){
                    //滑动未超过一半

                    inToolbarOpen.visibility = View.VISIBLE
                    inToolbarClose.visibility = View.GONE
                    var scale2 :Double = offset.div(scrollRange.div(2))
                    flToolBarSearch.alpha =scale2.toFloat()

                    var alpha2 :Int = scale2.times(255).toInt()
                    bgToolbarOpen.setBackgroundColor(Color.argb(alpha2,0,0,0))
                }else {
                    //滑动超过一半
                    inToolbarClose.visibility = View.VISIBLE
                    inToolbarClose.visibility = View.GONE
                    var scale3 :Double = scrollRange.minus(offset) .div(scrollRange.div(2))
                    flToolBarSearch.alpha = scale3.toFloat()

                    var alpha3 :Int = scale3.times(255).toInt()
                    bgToolbarClose.setBackgroundColor(Color.argb(alpha3,0,0,0))
                }

                var scale : Double = offset.div(scrollRange)
                var alpha :Int = scale.times(255).toInt()
                bgContent.setBackgroundColor(Color.argb(alpha,25,131,209))

            }
        })

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
    //切换Fragment
    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment )
        }

        manager.show(mStack[position])
        manager.commit()
    }

    //大部分控件的点击事件
    @SuppressLint("WrongConstant")
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.llFrozen -> changeFragment(0)
            R.id.llNews -> changeFragment(1)
            R.id.llWork -> changeFragment(2)
            R.id.tvMall2 -> changeFragment(0)
            R.id.tvNews2 -> changeFragment(1)
            R.id.tvWork2 -> changeFragment(2)
            R.id.flContentSearch ->  {
                val intent = Intent()
                intent.setClass(this, SearchActivity::class.java)
                startActivity(intent)

            }
            R.id.ivScan -> {
                val intent = Intent()
                intent.setClass(this, ScanActivity::class.java)
                startActivity(intent)
            }

            R.id.ivToolBarMyCenter -> {
                main_drawer.openDrawer(Gravity.START, true)
            }

            R.id.tvNavIdentity -> {
                val intent = Intent()
                intent.setClass(this, IdentityAuthActivity::class.java)
                startActivity(intent)
            }

            R.id.tvNavPerson -> {
                val intent = Intent()
                intent.setClass(this, PersonInforActicity::class.java)
                startActivity(intent)
            }

            R.id.tvNavSetting -> {
                val intent = Intent()
                intent.setClass(this, SettingActivity::class.java)
                startActivity(intent)
            }
        }
    }
        //下拉刷新的事件
//    override fun onRefresh() {
//        //关闭下拉刷新进度条
//        srlMain.isRefreshing = false
//
//      }

    //底部导航项的选中事件 ，弹出新的 Acticity
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when ( item.itemId ) {
            R.id.iChat -> {
                val intent = Intent()
                intent.setClass(this, ChatActivity::class.java)
                startActivity(intent)
            }

            R.id.iTalk -> {
                val intent = Intent()
                intent.setClass(this, TalkActivity::class.java)
                startActivity(intent)
            }
            R.id.iToolBox -> {
                val intent = Intent()
                intent.setClass(this, ToolBoxActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}



