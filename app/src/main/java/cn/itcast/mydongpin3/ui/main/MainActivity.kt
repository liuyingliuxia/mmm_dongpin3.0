package cn.itcast.mydongpin3.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.frozen.FrozenFragment
import cn.itcast.mydongpin3.ui.main.news.NewsFragment
import cn.itcast.mydongpin3.ui.main.work.WorkFragment
import cn.itcast.mydongpin3.ui.toolbox.ToolBoxActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenuView
import com.sotia.mydongpin.ui.scan.ScanActivity
import com.sotia.mydongpin.ui.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_left_drawr.*
import kotlinx.android.synthetic.main.in_open_title.*
import kotlinx.android.synthetic.main.in_toolbar_open.*
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener,SwipeRefreshLayout.OnRefreshListener ,BottomNavigationView.OnNavigationItemSelectedListener{

    private val mStack = Stack <Fragment> ()
    private val mFrozenFragment by lazy { FrozenFragment() }
    private val mNewsFragment by lazy { NewsFragment () }
    private val mWorkFragment by lazy { WorkFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        changeFragment(0)

        flContentSearch.setOnClickListener (this)
        llFrozen.setOnClickListener (this)
        llNews.setOnClickListener (this)
        llWork.setOnClickListener (this)
        ivScan.setOnClickListener (this)

        //DrawerLayout 抽屉拉出的点击事件
        ivToolBarMyCenter.setOnClickListener (this)

        //底部导航栏item的点击事件
        bnvMain.setOnNavigationItemSelectedListener(this)

        //下拉刷新 和 向下滑动的手势冲突
       // srlMain.setOnRefreshListener (this)
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

    @SuppressLint("WrongConstant")
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.llFrozen -> changeFragment(0)
            R.id.llNews -> changeFragment(1)
            R.id.llWork -> changeFragment(2)
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
        }
    }

    override fun onRefresh() {
        srlMain.isRefreshing = false
      }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when ( item.itemId ) {
            R.id.iChat -> { null }
            R.id.iTalk -> { null }
            R.id.iToolBox -> {
                val intent = Intent()
                intent.setClass(this, ToolBoxActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}

