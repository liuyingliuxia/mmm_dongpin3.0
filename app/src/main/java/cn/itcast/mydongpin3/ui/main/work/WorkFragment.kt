package cn.itcast.mydongpin3.ui.main.work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.news.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.view.*

/**
 * 我的工作 碎片
 */
class WorkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView =  inflater.inflate(R.layout.fragment_work, container,false)

        return mView

    }


}
