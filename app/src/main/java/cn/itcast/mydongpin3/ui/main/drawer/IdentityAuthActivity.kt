package cn.itcast.mydongpin3.ui.main.drawer


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_choose_identity.*
import kotlinx.android.synthetic.main.activity_setting.ivBack

//身份认证窗口
class IdentityAuthActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_identity)
        ivBack.setOnClickListener(this)
        btnWholesaler.setOnClickListener(this)
        btnManufaturer.setOnClickListener(this)
        btnTerminal.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.ivBack ->{
                    finish()
                }

            R.id.btnWholesaler -> {
                val intent = Intent()
                intent.setClass(this, UserAuthAcitivty::class.java)
                startActivity(intent)

            }

            R.id.btnManufaturer ->{
                val intent = Intent()
                intent.setClass(this, UserAuthAcitivty::class.java)
                startActivity(intent)
            }

            R.id.btnTerminal -> {
                val intent = Intent()
                intent.setClass(this, UserAuthAcitivty::class.java)
                startActivity(intent)
            }

        }
    }
}