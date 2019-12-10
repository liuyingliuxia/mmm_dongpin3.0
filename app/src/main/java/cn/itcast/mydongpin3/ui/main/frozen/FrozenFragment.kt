package cn.itcast.mydongpin3.ui.main.frozen

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cn.itcast.easy_recycler.MallAdapter
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.entity.Goods
import cn.itcast.mydongpin3.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_frozen.*
import kotlinx.android.synthetic.main.fragment_frozen.view.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * 冻品商城 碎片
 */
class FrozenFragment : Fragment(),SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        srlMain.isRefreshing = false
        addData()
    }

    private var list: MutableList<String> = ArrayList()
    private lateinit var adapter: MallAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_frozen, container, false)
        list = getList()
        adapter = MallAdapter(list, context!!)
        gridLayoutManager = GridLayoutManager(context, 2)
        gridLayoutManager.orientation = GridLayoutManager.VERTICAL
        mView.rv_mall.layoutManager = gridLayoutManager
        mView.rv_mall.adapter = adapter
        adapter.setOnItemClick(object : MallAdapter.OnItemClickListener {
            override fun OnItemClick(view: View, position: Int) {
                Toast.makeText(activity, position.plus(1).toString(), Toast.LENGTH_SHORT).show()
            }
        })

        //下拉刷新item
        //报错 ：void androidx.recyclerview.widget.RecyclerView.setOnScrollListener(androidx.recyclerview.widget.RecyclerView$OnScrollListener)' on a null object reference
        rv_mall.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            var lastVisibleItem: Int? = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem!! + 1 == adapter?.itemCount) {
                    addData()
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                //最后一个可见的ITEM
                lastVisibleItem = layoutManager.findLastVisibleItemPosition()
            }
        })

        //返回 Fragment的 View
        return view
    }

    fun getList(): MutableList<String> {

        for (i in 1..4) {
            list.add(i.times(10).toString() + "人浏览")
        }
        return list
    }

    //添加数据
    private fun addData() {
        for (i in 5..8) {
            list.add(i.times(3).toString() + "人浏览")
            rv_mall.adapter?.notifyDataSetChanged()
        }
    }
}




