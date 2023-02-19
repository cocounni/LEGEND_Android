package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_etc.*

class EtcActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etc)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DubuButton.setOnClickListener {
            Datafun().Dubufun(this)
        }
        SundubuButton.setOnClickListener {
            Datafun().Sundubufun(this)
        }
        KongbijiButton.setOnClickListener {
            Datafun().Kongbijifun(this)
        }
        YubuButton.setOnClickListener {
            Datafun().Yubufun(this)
        }

        TorefButton.setOnClickListener {
            this@EtcActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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