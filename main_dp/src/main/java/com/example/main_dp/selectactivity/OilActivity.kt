package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_oil.*

class OilActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oil)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        OliveoilButton.setOnClickListener {
            Datafun().Oliveoilfun(this)
        }
        ChamoilButton.setOnClickListener {
            Datafun().Chamoilfun(this)
        }
        VegeoilButton.setOnClickListener {
            Datafun().Vegeoilfun(this)
        }
        GochuoilButton.setOnClickListener {
            Datafun().Gochuoilfun(this)
        }
        FryoilButton.setOnClickListener {
            Datafun().Fryoilfun(this)
        }
        YutoilButton.setOnClickListener {
            Datafun().Yutoilfun(this)
        }
        SikoilButton.setOnClickListener {
            Datafun().Sikoilfun(this)
        }
        SaladoilButton.setOnClickListener {
            Datafun().Saladoilfun(this)
        }
        PodossioilButton.setOnClickListener {
            Datafun().Podossioilfun(this)
        }
        DuloilButton.setOnClickListener {
            Datafun().Duloilfun(this)
        }

        TorefButton.setOnClickListener {
            this@OilActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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