package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_grain.*

class GrainActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grain)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        SsalButton.setOnClickListener {
            Datafun().Ssalfun(this)
        }
        ChapssalButton.setOnClickListener {
            Datafun().Chapssalfun(this)
        }
        SusuButton.setOnClickListener {
            Datafun().Susufun(this)
        }
        ChajoButton.setOnClickListener {
            Datafun().Chajofun(this)
        }
        JunbunButton.setOnClickListener {
            Datafun().Junbunfun(this)
        }
        MilgaruButton.setOnClickListener {
            Datafun().Milgarufun(this)
        }
        ChapsslagaruButton.setOnClickListener {
            Datafun().Chapsslagarufun(this)
        }
        NokmalButton.setOnClickListener {
            Datafun().Nokmalfun(this)
        }
        DelggaegaruButton.setOnClickListener {
            Datafun().Delggaegarufun(this)
        }
        NokmalgaruButton.setOnClickListener {
            Datafun().Nokmalgarufun(this)
        }
        GangryuckButton.setOnClickListener {
            Datafun().Gangryuckfun(this)
        }
        JatgaruButton.setOnClickListener {
            Datafun().Jatgarufun(this)
        }
        FrygaruButton.setOnClickListener {
            Datafun().Frygarufun(this)
        }
        KongButton.setOnClickListener {
            Datafun().Kongfun(this)
        }
        PatButton.setOnClickListener {
            Datafun().Patfun(this)
        }
        HukimjaButton.setOnClickListener {
            Datafun().Hukimjafun(this)
        }
        WanduButton.setOnClickListener {
            Datafun().Wandufun(this)
        }
        PeanutButton.setOnClickListener {
            Datafun().Peanutfun(this)
        }
        GgaeButton.setOnClickListener {
            Datafun().Ggaefun(this)
        }

        TorefButton.setOnClickListener {
            this@GrainActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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