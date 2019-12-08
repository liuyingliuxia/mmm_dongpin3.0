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

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private val mStack = Stack <Fragment> ()
    private val mFrozenFragment by lazy { FrozenFragment() }
    private val mNewsFragment by lazy { NewsFragment () }
    private val mWorkFragment by lazy { WorkFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        changeFragment(0)
        llSearch.setOnClickListener (this)
        llFrozen.setOnClickListener (this)
        llNews.setOnClickListener (this)
        llWork.setOnClickListener (this)
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

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.llFrozen -> changeFragment(0)
            R.id.llNews -> changeFragment(1)
            R.id.llWork -> changeFragment(2)
            R.id.llSearch ->  {
                val intent = Intent()
                intent.setClass(this, SearchActivity::class.java)
                startActivity(intent)

            }
        }
    }

}

