package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_pro.*

class ProActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        CrapmatsalButton.setOnClickListener {
            Datafun().Crapmatsalfun(this)
        }
        UmukButton.setOnClickListener {
            Datafun().Umukfun(this)
        }
        HamButton.setOnClickListener {
            Datafun().Hamfun(this)
        }
        BaconButton.setOnClickListener {
            Datafun().Baconfun(this)
        }
        FranksausageButton.setOnClickListener {
            Datafun().Franksausagefun(this)
        }
        ViennasausageButton.setOnClickListener {
            Datafun().Viennasausagefun(this)
        }
        GolbangcanButton.setOnClickListener {
            Datafun().Golbangcanfun(this)
        }
        GgongchicanButton.setOnClickListener {
            Datafun().Ggongchicanfun(this)
        }
        ChamchicanButton.setOnClickListener {
            Datafun().Chamchicanfun(this)
        }
        FruitcanButton.setOnClickListener {
            Datafun().Fruitcanfun(this)
        }

        TorefButton.setOnClickListener {
            this@ProActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}