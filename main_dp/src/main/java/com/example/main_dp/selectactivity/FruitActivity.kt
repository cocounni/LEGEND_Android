package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_fruit.*

class FruitActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        AppleButton.setOnClickListener {
            Datafun().Applefun(this)
        }
        GrapefruitButton.setOnClickListener {
            Datafun().Grapefruitfun(this)
        }
        StrawberryButton.setOnClickListener {
            Datafun().Strawberryfun(this)
        }
        DriedgrapeButton.setOnClickListener {
            Datafun().Driedgrapefun(this)
        }
        LemonButton.setOnClickListener {
            Datafun().Lemonfun(this)
        }
        GrapeButton.setOnClickListener {
            Datafun().Grapefun(this)
        }
        CherryButton.setOnClickListener {
            Datafun().Cherryfun(this)
        }
        AvocadoButton.setOnClickListener {
            Datafun().Avocadofun(this)
        }
        BananaButton.setOnClickListener {
            Datafun().Bananafun(this)
        }
        OrangeButton.setOnClickListener {
            Datafun().Orangefun(this)
        }
        LimeButton.setOnClickListener {
            Datafun().Limefun(this)
        }
        BlueberryButton.setOnClickListener {
            Datafun().Blueberryfun(this)
        }

        TorefButton.setOnClickListener {
            this@FruitActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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