package cn.itcast.mydongpin3.ui.toolbox

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_scan.*
import kotlinx.android.synthetic.main.activity_toolbox.*

class ToolBoxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbox)
        ivBack.setOnClickListener() {
          finish()
        }
    }
}

