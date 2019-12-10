package cn.itcast.mydongpin3.ui.main.drawer

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.MainActivity
import com.sotia.mydongpin.ui.login.SingleLoginActivity
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        ivBack.setOnClickListener(this)
        llAboutUs.setOnClickListener(this)
        llClearCache.setOnClickListener(this)
        btnQuitLogin.setOnClickListener(this)

    }

    override  fun onClick (v :View?) {
        when (v?.id) {

            R.id.ivBack ->{
               finish()

            }
            R.id.llAboutUs -> {
                val intent = Intent()
                intent.setClass(this, AboutUsActivity::class.java)
                startActivity(intent)
            }
            R.id.llClearCache -> {

            }

            R.id.btnQuitLogin -> {
                val intent = Intent()
                intent.setClass(this, SingleLoginActivity::class.java)
                startActivity(intent)

            }
        }

    }

}