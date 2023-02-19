package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_fish.*

class FishActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        MylchiButton.setOnClickListener {
            Datafun().Mylchifun(this)
        }
        SquidButton.setOnClickListener {
            Datafun().Squidfun(this)
        }
        BukuhButton.setOnClickListener {
            Datafun().Bukuhfun(this)
        }
        SangtaeButton.setOnClickListener {
            Datafun().Sangtaefun(this)
        }
        SalmonButton.setOnClickListener {
            Datafun().Salmonfun(this)
        }
        BoiledoctoButton.setOnClickListener {
            Datafun().Boiledoctofun(this)
        }
        GapsquidButton.setOnClickListener {
            Datafun().Gapsquidfun(this)
        }
        GgolddugiButton.setOnClickListener {
            Datafun().Ggolddugifun(this)
        }
        JjukumiButton.setOnClickListener {
            Datafun().Jjukumifun(this)
        }
        DomiButton.setOnClickListener {
            Datafun().Domifun(this)
        }
        JanmylchiButton.setOnClickListener {
            Datafun().Janmylchifun(this)
        }
        GalchiButton.setOnClickListener {
            Datafun().Galchifun(this)
        }
        DaeguButton.setOnClickListener {
            Datafun().Daegufun(this)
        }
        DongtaeButton.setOnClickListener {
            Datafun().Dongtaefun(this)
        }
        JunuhButton.setOnClickListener {
            Datafun().Junuhfun(this)
        }
        MaegiButton.setOnClickListener {
            Datafun().Maegifun(this)
        }
        InguhButton.setOnClickListener {
            Datafun().Inguhfun(this)
        }
        SonguhButton.setOnClickListener {
            Datafun().Songuhfun(this)
        }
        AguButton.setOnClickListener {
            Datafun().Agufun(this)
        }
        JogiButton.setOnClickListener {
            Datafun().Jogifun(this)
        }
        NakjiButton.setOnClickListener {
            Datafun().Nakjifun(this)
        }
        DriedsquidButton.setOnClickListener {
            Datafun().Driedsquidfun(this)
        }
        ChamchiButton.setOnClickListener {
            Datafun().Chamchifun(this)
        }
        OctopusButton.setOnClickListener {
            Datafun().Octopusfun(this)
        }
        GgongchiButton.setOnClickListener {
            Datafun().Ggongchifun(this)
        }
        GodungButton.setOnClickListener {
            Datafun().Godungfun(this)
        }
        HunjaesalmonButton.setOnClickListener {
            Datafun().Hunjaesalmonfun(this)
        }
        CodariButton.setOnClickListener {
            Datafun().Codarifun(this)
        }
        GwanguhButton.setOnClickListener {
            Datafun().Gwanguhfun(this)
        }
        JanguhButton.setOnClickListener {
            Datafun().Janguhfun(this)
        }

        TorefButton.setOnClickListener {
            this@FishActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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