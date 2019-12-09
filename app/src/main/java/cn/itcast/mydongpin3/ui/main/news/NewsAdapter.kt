package cn.itcast.mydongpin3.ui.main.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.itcast.mydongpin3.R
import kotlinx.android.synthetic.main.item_frozen_mall.view.*

class NewsAdapter(var list:  MutableList<String>, var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onClick: OnItemClickListener? = null

    fun setOnItemClick(onItemClickListener: OnItemClickListener) {
        this.onClick = onItemClickListener
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_news, p0, false)
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
        viewHolder.itemView.tvPageView.text = list[position]

        viewHolder.itemView.tag = position
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun OnItemClick(view: View, position: Int)
    }

}