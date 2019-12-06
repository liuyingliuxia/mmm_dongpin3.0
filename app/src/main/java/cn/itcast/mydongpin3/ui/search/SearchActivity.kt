package com.sotia.mydongpin.ui.search

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.ui.main.MainActivity
import cn.itcast.mydongpin3.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        tvCancel.setOnClickListener (this)
        tvClearHistory.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
       when (v?.id){

           R.id.tvClearHistory -> {
               AlertDialog.Builder(this)
                   .setMessage("确认删除全部搜索历史")
                   .setTitle("温馨提示")
                   .setPositiveButton("确定") {
                       _,_ -> run{
                       findViewById<TextView>(R.id.tvClearHistory).visibility = View.GONE
                       findViewById<TextView>(R.id.tvSearchHistory).visibility = View.GONE
                   }

                   }
                   .setNeutralButton("取消", null)
                   .create()
                   .show()
           }

          R.id.tvCancel -> {
                   val scanIntent = Intent()
                   scanIntent.setClass(this, MainActivity::class.java)
                   startActivity(scanIntent)
          }
       }
    }
}