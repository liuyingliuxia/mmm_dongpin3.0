package cn.itcast.mydongpin3.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.itcast.mydongpin3.R

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        //谈吹 dialog 让用户先认证
    }
}
