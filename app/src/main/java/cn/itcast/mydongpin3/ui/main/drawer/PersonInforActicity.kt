package cn.itcast.mydongpin3.ui.main.drawer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_edit_infor.*
import kotlinx.android.synthetic.main.activity_edit_infor.tvClose

class PersonInforActicity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_infor)

        tvClose.setOnClickListener {
           finish()
        }


        //姓名监听器弹出对话框
        llName.setOnClickListener(){
        }

        //选择性别的对话框
        llSex.setOnClickListener(){
            val sexlist = arrayOf("保密","男","女")
            val sexBuilder = AlertDialog.Builder(this@PersonInforActicity)
            sexBuilder.setTitle("选择性别")
                .setNegativeButton("取消",null)
                .setPositiveButton("确定",null)
                .setItems(sexlist){
                        _,_ -> }.create()

        }


    }


}