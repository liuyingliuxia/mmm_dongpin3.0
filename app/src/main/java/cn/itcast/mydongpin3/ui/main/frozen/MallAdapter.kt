package cn.itcast.mydongpin3.ui.main.frozen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.entity.Goods
import kotlinx.android.synthetic.main.item_frozen_mall.view.*

class MallAdapter(var list: MutableList<Goods>, var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mGoodsList: MutableList<Goods> = ArrayList()
    var onClick: Holder.OnItemClickListener? = null

    fun setOnItemClick(onItemClickListener: Holder.OnItemClickListener) {
        this.onClick = onItemClickListener
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_frozen_mall, p0, false)
        val holder = Holder(itemView)

        itemView.setOnClickListener {
            onClick!!.OnItemClick(itemView, itemView.tag as Int)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        var goodData: Goods = mGoodsList[position]
        viewHolder.itemView.findViewById<TextView >(R.id.tvGoodSpecification).setText(goodData.goodsSpecifi)
        viewHolder.itemView.findViewById<TextView >(R.id.tvPageView).setText(goodData.pageView)
        viewHolder.itemView.findViewById<TextView >(R.id.tvPrice).setText(goodData.goodsPrice)
        viewHolder.itemView.findViewById<TextView >(R.id.tvGoodsName).setText(goodData.goodsName)
    }
}
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        interface OnItemClickListener {
            fun OnItemClick(view: View, position: Int)
        }
    }