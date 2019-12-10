package cn.itcast.mydongpin3.ui.talk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import cn.itcast.mydongpin3.R
import kotlinx.android.synthetic.main.activity_talk.*

class TalkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk)
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
}
