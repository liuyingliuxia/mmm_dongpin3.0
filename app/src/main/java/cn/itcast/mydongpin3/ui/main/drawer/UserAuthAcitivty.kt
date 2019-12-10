package cn.itcast.mydongpin3.ui.main.drawer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R
import kotlinx.android.synthetic.main.activity_user_auth.*

class UserAuthAcitivty: AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_auth)
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.ivBack -> {
                finish()
            }
        }
    }
}