package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_vege.*

class VegeActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vege)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        KongnamulButton.setOnClickListener {
            Datafun().Kongnamulfun(this)
        }
        SukjuButton.setOnClickListener {
            Datafun().Sukjufun(this)
        }
        MinariButton.setOnClickListener {
            Datafun().Minarifun(this)
        }
        GreenonionButton.setOnClickListener {
            Datafun().Greenonionfun(this)
        }
        DorajiButton.setOnClickListener {
            Datafun().Dorajifun(this)
        }
        GosariButton.setOnClickListener {
            Datafun().Gosarifun(this)
        }
        ShigumchiButton.setOnClickListener {
            Datafun().Shigumchifun(this)
        }
        PyogoButton.setOnClickListener {
            Datafun().Pyogofun(this)
        }
        YangsongButton.setOnClickListener {
            Datafun().Yangsongfun(this)
        }
        NutariButton.setOnClickListener {
            Datafun().Nutarifun(this)
        }
        MokiButton.setOnClickListener {
            Datafun().Mokifun(this)
        }
        SaesongButton.setOnClickListener {
            Datafun().Saesongfun(this)
        }
        PangeButton.setOnClickListener {
            Datafun().Pangefun(this)
        }
        AehobakButton.setOnClickListener {
            Datafun().Aehobakfun(this)
        }
        HobakButton.setOnClickListener {
            Datafun().Hobakfun(this)
        }
        CarrotButton.setOnClickListener {
            Datafun().Carrotfun(this)
        }
        BuchuButton.setOnClickListener {
            Datafun().Buchufun(this)
        }
        GochuButton.setOnClickListener {
            Datafun().Gochufun(this)
        }
        GarlicButton.setOnClickListener {
            Datafun().Garlicfun(this)
        }
        DaechuButton.setOnClickListener {
            Datafun().Daechufun(this)
        }
        PotatoButton.setOnClickListener {
            Datafun().Potatofun(this)
        }
        OnionButton.setOnClickListener {
            Datafun().Onionfun(this)
        }
        PimangButton.setOnClickListener {
            Datafun().Pimangfun(this)
        }
        PapricaButton.setOnClickListener {
            Datafun().Papricafun(this)
        }
        CucumberButton.setOnClickListener {
            Datafun().Cucumberfun(this)
        }
        SangchuButton.setOnClickListener {
            Datafun().Sangchufun(this)
        }
        GgatipButton.setOnClickListener {
            Datafun().Ggatipfun(this)
        }
        MuButton.setOnClickListener {
            Datafun().Mufun(this)
        }
        BrocoliButton.setOnClickListener {
            Datafun().Brocolifun(this)
        }
        ChunggyungButton.setOnClickListener {
            Datafun().Chunggyungfun(this)
        }
        BangtoButton.setOnClickListener {
            Datafun().Bangtofun(this)
        }
        TomatoButton.setOnClickListener {
            Datafun().Tomatofun(this)
        }
        BamButton.setOnClickListener {
            Datafun().Bamfun(this)
        }
        BaechuButton.setOnClickListener {
            Datafun().Baechufun(this)
        }
        KimchiButton.setOnClickListener {
            Datafun().Kimchifun(this)
        }
        YungeunButton.setOnClickListener {
            Datafun().Yungeunfun(this)
        }
        YangsangchuButton.setOnClickListener {
            Datafun().Yangsangchufun(this)
        }
        YangbaechuButton.setOnClickListener {
            Datafun().Yangbaechufun(this)
        }
        GogumaButton.setOnClickListener {
            Datafun().Gogumafun(this)
        }
        OksusuButton.setOnClickListener {
            Datafun().Oksusufun(this)
        }

        TorefButton.setOnClickListener {
            this@VegeActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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