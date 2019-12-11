package cn.itcast.mydongpin3.ui.main.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cn.itcast.easy_recycler.MallAdapter
import cn.itcast.mydongpin3.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_frozen.*
import kotlinx.android.synthetic.main.fragment_frozen.view.*
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*

/**
 * 今日资讯 碎片
 */
class NewsFragment : Fragment() {
    private var list: MutableList<String> = ArrayList()
    private lateinit var adapter: NewsAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView =  inflater.inflate(R.layout.fragment_news, container,false)
        list = getList()
        adapter = NewsAdapter(list, context!!)
        gridLayoutManager = GridLayoutManager(context,1)
        gridLayoutManager.orientation = GridLayoutManager.VERTICAL
        mView.rv_news.layoutManager = gridLayoutManager
        mView.rv_news.adapter = adapter
        adapter.setOnItemClick(object : NewsAdapter.OnItemClickListener {
            override fun OnItemClick(view: View, position: Int) {
                Toast.makeText(activity, position.plus(1).toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mView

    }


    fun getList(): MutableList<String> {

        for (i in 1..10) {
            list.add(i.times(10).toString())
        }
        return list
    }

//    override fun onRefresh() {
//      srlMain.isRefreshing = false
//        addData()
//    }

}

