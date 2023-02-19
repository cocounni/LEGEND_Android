package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sauce.*

class SauceActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sauce)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        SoysauceButton.setOnClickListener {
            Datafun().Soysaucefun(this)
        }
        GochujangButton.setOnClickListener {
            Datafun().Gochujangfun(this)
        }
        GochugaruButton.setOnClickListener {
            Datafun().Gochugarufun(this)
        }
        SaltButton.setOnClickListener {
            Datafun().Saltfun(this)
        }
        HoneyButton.setOnClickListener {
            Datafun().Honeyfun(this)
        }
        DajingarlicButton.setOnClickListener {
            Datafun().Dajingarlicfun(this)
        }
        DoanjangButton.setOnClickListener {
            Datafun().Doanjangfun(this)
        }
        MayonnaiseButton.setOnClickListener {
            Datafun().Mayonnaisefun(this)
        }
        MustardButton.setOnClickListener {
            Datafun().Mustardfun(this)
        }
        MulyotButton.setOnClickListener {
            Datafun().Mulyotfun(this)
        }
        ButterButton.setOnClickListener {
            Datafun().Butterfun(this)
        }
        SugerButton.setOnClickListener {
            Datafun().Sugerfun(this)
        }
        MiwonButton.setOnClickListener {
            Datafun().Miwonfun(this)
        }
        SsamjangButton.setOnClickListener {
            Datafun().Ssamjangfun(this)
        }
        DashidaButton.setOnClickListener {
            Datafun().Dashidafun(this)
        }
        VinegerButton.setOnClickListener {
            Datafun().Vinegerfun(this)
        }
        OligodangButton.setOnClickListener {
            Datafun().Oligodangfun(this)
        }
        ChungukjangButton.setOnClickListener {
            Datafun().Chungukjangfun(this)
        }
        ChojangButton.setOnClickListener {
            Datafun().Chojangfun(this)
        }
        ChunjangButton.setOnClickListener {
            Datafun().Chunjangfun(this)
        }
        ChilisauceButton.setOnClickListener {
            Datafun().Chilisaucefun(this)
        }
        KetchupButton.setOnClickListener {
            Datafun().Ketchupfun(this)
        }
        PepperButton.setOnClickListener {
            Datafun().Pepperfun(this)
        }
        JutgukButton.setOnClickListener {
            Datafun().Jutgukfun(this)
        }
        LemonjuiceButton.setOnClickListener {
            Datafun().Lemonjuicefun(this)
        }
        ShirimpjutButton.setOnClickListener {
            Datafun().Shirimpjutfun(this)
        }
        DriedshirimpgaruButton.setOnClickListener {
            Datafun().Driedshirimpgarufun(this)
        }
        YuksumulchiButton.setOnClickListener {
            Datafun().Yuksumulchifun(this)
        }
        KatsuobushiButton.setOnClickListener {
            Datafun().Katsuobushifun(this)
        }
        Driedshirimp.setOnClickListener {
            Datafun().Driedshirimpfun(this)
        }

        TorefButton.setOnClickListener {
            this@SauceActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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