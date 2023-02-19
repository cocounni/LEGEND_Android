package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_crap.*

class CrapActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crap)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        ShirimpButton.setOnClickListener {
            Datafun().Shirimpfun(this)
        }
        FlowercrapButton.setOnClickListener {
            Datafun().Flowercrapfun(this)
        }
        CrapButton.setOnClickListener {
            Datafun().Crapfun(this)
        }
        DaehaButton.setOnClickListener {
            Datafun().Daehafun(this)
        }
        CocktailshirimpButton.setOnClickListener {
            Datafun().Cocktailshirimpfun(this)
        }
        TorefButton.setOnClickListener {
            this@CrapActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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