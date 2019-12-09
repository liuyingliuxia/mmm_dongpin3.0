package com.sotia.mydongpin.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
         tvLogin.setOnClickListener{
             val intent = Intent()
             intent.setClass(this, MainActivity::class.java)
             startActivity(intent)
         }
    }
}