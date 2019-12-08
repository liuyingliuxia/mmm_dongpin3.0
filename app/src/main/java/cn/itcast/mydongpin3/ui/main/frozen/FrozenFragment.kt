package cn.itcast.mydongpin3.ui.main.frozen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.itcast.easy_recycler.MallAdapter
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.entity.Goods
import cn.itcast.mydongpin3.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_frozen.*
import kotlinx.android.synthetic.main.fragment_frozen.view.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * 冻品商城 碎片
 */
class FrozenFragment : Fragment(){
    private var list: MutableList<String> = ArrayList()
    private lateinit var adapter: MallAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView =  inflater.inflate(R.layout.fragment_frozen, container,false)
        list = getList()
        adapter = MallAdapter(list, context!!)
        gridLayoutManager = GridLayoutManager(context,2)
        gridLayoutManager.orientation = GridLayoutManager.VERTICAL
        mView.rv_mall.layoutManager = gridLayoutManager
        mView.rv_mall.adapter = adapter
        adapter.setOnItemClick(object : MallAdapter.OnItemClickListener {
            override fun OnItemClick(view: View, position: Int) {
                Toast.makeText(activity, position.plus(1).toString(), Toast.LENGTH_SHORT).show()
            }
        })
        return mView

    }


    fun getList(): MutableList<String> {

        for (i in 1..10) {
            list.add(i.times(10).toString()+"人浏览")
        }
        return list
    }

}



