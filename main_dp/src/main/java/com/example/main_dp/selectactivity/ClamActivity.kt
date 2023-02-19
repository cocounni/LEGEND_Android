package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_clam.*

class ClamActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clam)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        HonghapButton.setOnClickListener {
            Datafun().Honghapfun(this)
        }
        MoshiButton.setOnClickListener {
            Datafun().Moshifun(this)
        }
        ChamsoraButton.setOnClickListener {
            Datafun().Chamsorafun(this)
        }
        GaribiButton.setOnClickListener {
            Datafun().Garibifun(this)
        }
        JaechupButton.setOnClickListener {
            Datafun().Jaechupfun(this)
        }
        GulButton.setOnClickListener {
            Datafun().Gulfun(this)
        }
        BajirakButton.setOnClickListener {
            Datafun().Bajirakfun(this)
        }
        GolbangButton.setOnClickListener {
            Datafun().Golbangfun(this)
        }
        MatclamButton.setOnClickListener {
            Datafun().Matclamfun(this)
        }
        ClamsalButton.setOnClickListener {
            Datafun().Clamsalfun(this)
        }
        PiclamButton.setOnClickListener {
            Datafun().Piclamfun(this)
        }
        JunbokButton.setOnClickListener {
            Datafun().Junbokfun(this)
        }
        MatsalclamButton.setOnClickListener {
            Datafun().Matsalclamfun(this)
        }

        TorefButton.setOnClickListener {
            this@ClamActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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