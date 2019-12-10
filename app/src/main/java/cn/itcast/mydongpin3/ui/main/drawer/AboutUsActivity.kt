package cn.itcast.mydongpin3.ui.main.drawer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R

class AboutUsActivity:AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.ivBack -> {
                finish()
            }
        }
    }
}