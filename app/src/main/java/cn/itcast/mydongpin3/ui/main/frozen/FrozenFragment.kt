package cn.itcast.mydongpin3.ui.main.frozen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.entity.Goods
import kotlinx.android.synthetic.main.fragment_frozen.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * 冻品商城 碎片
 */
class FrozenFragment : Fragment(){
    private var mGoodsList  : MutableList<Goods> = ArrayList ()
    private lateinit var adapter: MallAdapter
    private lateinit var GridLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initData()
        initRecyclerView()
        return inflater.inflate(R.layout.fragment_frozen, container,false)

    }

    private fun initData () {
        for ( i in 1 .. 10 ){
            val goods : Goods = Goods()
            goods.goodsName = "商品名称 " + i
            goods.goodsPrice = "商品价格 " + i
            goods.imgPath = "商品图片地址 " + i
            goods.pageView = " 浏览量 " + i

            mGoodsList.add(goods)
        }
    }

    private fun initRecyclerView() {
        activity
        val mRecyclerView :RecyclerView
        val mallAdapter : MallAdapter
         mallAdapter = MallAdapter(mGoodsList ,this.context!! )
        GridLayoutManager = GridLayoutManager(this.context ,2)
        rv_mall.layoutManager = GridLayoutManager
        rv_mall.adapter = mallAdapter

    }

}



