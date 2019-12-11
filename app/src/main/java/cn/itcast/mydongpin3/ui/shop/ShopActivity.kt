package cn.itcast.mydongpin3.ui.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.itcast.mydongpin3.R
import cn.itcast.mydongpin3.ui.sort.ProductSortActivity
import kotlinx.android.synthetic.main.activity_goods_detail.*
import kotlinx.android.synthetic.main.activity_goods_detail.ivBack
import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        ivBack.setOnClickListener(this)
        tvSort.setOnClickListener(this)
        tvMore.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when (v?.id) {
           R.id.ivBack -> {
               finish()
           }
           R.id.tvSort -> {
                val intent = Intent()
                intent.setClass(this, ProductSortActivity::class.java)
                startActivity(intent)
           }
           R.id.tvMore -> {

           }
       }
    }
}
