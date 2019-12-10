package com.sotia.mydongpin.ui.search

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import cn.itcast.mydongpin3.ui.main.MainActivity
import cn.itcast.mydongpin3.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() ,View.OnClickListener{
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        //点击事件：
        tvCancel.setOnClickListener (this)
        tvClearHistory.setOnClickListener(this)
        ivClean.setOnClickListener(this)
        ivBack.setOnClickListener (this)
        llProduct.setOnClickListener(this)
        llShop.setOnClickListener (this)
        //搜索框文字变化监听：
        etInput.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if ( etInput.text.isNullOrEmpty())
                {
                    ivClean.visibility =View.INVISIBLE
                }
                else
                {
                    ivClean.visibility =View.VISIBLE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        etInput.setOnEditorActionListener { _, actionId, _ ->
            if( actionId ==EditorInfo.IME_ACTION_SEARCH ) {
                ivBack.visibility = View.VISIBLE
                tvCancel.visibility = View.GONE
                Toast.makeText(this ,"开始搜索...",Toast.LENGTH_SHORT).show()
            }
            false
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
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
               finish()
          }
          R.id.ivBack -> {
              finish()
          }

          R.id.ivClean -> {
               ivClean.visibility = View.INVISIBLE
               tvCancel.visibility = View.VISIBLE
               ivBack.visibility =View.GONE
               etInput.setText(null)
               etInput.setHint(R.string.mmm_hint_please_input_search_content)
         }

         R.id.llProduct -> {
            tvProduct.setTextColor(getColor(R.color.yellow))
             tvShop.setTextColor(getColor(R.color.color_hint))
             vItemBottomLine.visibility = View.VISIBLE
             vItemBottomLine2.visibility = View.INVISIBLE
         }

         R.id.llShop -> {
             tvProduct.setTextColor(getColor(R.color.color_hint))
             tvShop.setTextColor(getColor(R.color.yellow))
             vItemBottomLine.visibility = View.INVISIBLE
             vItemBottomLine2.visibility = View.VISIBLE
         }
       }
    }

}