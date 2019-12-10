package cn.itcast.mydongpin3.ui.main.work

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.drawer.IdentityAuthActivity
import kotlinx.android.synthetic.main.fragment_work.*

/**
 * 我的工作 碎片
 */
class WorkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_work, container, false)
        return mView
    }

    //kotlin 中在 Fragment 的事件监听要在 return View 之后 ，所以写在onViewCreated中 ，和 Java不同
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBeginAuth.setOnClickListener {
            val intent = Intent()
            intent.setClass(context!!, IdentityAuthActivity::class.java)
            startActivity(intent)
        }
    }
}
