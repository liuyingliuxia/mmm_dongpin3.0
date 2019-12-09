package com.sotia.mydongpin.ui.scan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_scan.*

class ScanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
        tvBack.setOnClickListener() {
            val scanIntent = Intent()
            scanIntent.setClass(this, MainActivity::class.java)
            startActivity(scanIntent)
        }

    }
}