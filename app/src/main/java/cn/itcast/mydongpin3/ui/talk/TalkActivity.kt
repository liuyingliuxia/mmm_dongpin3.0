package cn.itcast.mydongpin3.ui.talk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import cn.itcast.mydongpin3.R
import kotlinx.android.synthetic.main.activity_talk.*

class TalkActivity : AppCompatActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk)
        ivMenu.setOnClickListener(this)
        ivBack.setOnClickListener(this)
        ivFace.setOnClickListener(this)
        ivAdd.setOnClickListener(this)
        tvSend.setOnClickListener(this)
        ivTalk.setOnClickListener(this)

        etTalk.addTextChangedListener( object :TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if( etTalk.text.isNullOrEmpty()){
                    ivAdd.visibility = View.VISIBLE
                    tvSend.visibility = View.GONE
                }else {
                    ivAdd.visibility = View.GONE
                    tvSend.visibility = View.VISIBLE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
             }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
             }
        })
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.ivBack -> {
                finish()
            }
            R.id.ivFace -> {

            }
            R.id.ivAdd -> {

            }
            R.id.tvSend -> {

            }
            R.id.ivMenu -> {
                val intent = Intent()
                intent.setClass(this,TalkSettingActivity::class.java)
                startActivity(intent)
            }
            R.id.ivTalk -> {

            }
        }
    }
}
