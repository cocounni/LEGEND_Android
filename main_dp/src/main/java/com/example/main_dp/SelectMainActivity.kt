package com.example.main_dp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.R.layout.activity_main_select
import com.example.main_dp.selectactivity.*
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.selectfcts.Search
import kotlinx.android.synthetic.main.activity_main_select.*

class SelectMainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(activity_main_select)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)//액션바뒤로가기

                /// 검색 기능 구현 ///
                val searchList = Search().searchlist //검색창 자동완성 리스트
                val searchAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, searchList)

                searchmain.setAdapter(searchAdapter)

                searchmain.setOnItemClickListener { adapterView, view, position, rowId ->
                        val inputName = adapterView.getItemAtPosition(position) //클릭한 재료 이름 저장

                        Search().Searchfun(inputName.toString(), this) //이벤트

                        searchmain.setText("", false) //검색창 초기화
                        searchmain.clearFocus() //키보드 내리기
                }


                /// 선택 액티비티로 이동 ///
                meatButton.setOnClickListener {
                        val intent = Intent(this, MeatMidActivity::class.java)
                        startActivity(intent)
                }
                vegeButton.setOnClickListener {
                        val intent = Intent(this, VegeActivity::class.java)
                        startActivity(intent)
                }
                fruitButton.setOnClickListener {
                        val intent = Intent(this, FruitActivity::class.java)
                        startActivity(intent)
                }
                dairyButton.setOnClickListener {
                        val intent = Intent(this, DairyActivity::class.java)
                        startActivity(intent)
                }
                breadButton.setOnClickListener {
                        val intent = Intent(this, BreadActivity::class.java)
                        startActivity(intent)
                }
                grainButton.setOnClickListener {
                        val intent = Intent(this, GrainActivity::class.java)
                        startActivity(intent)
                }
                fishButton.setOnClickListener {
                        val intent = Intent(this, FishMidActivity::class.java)
                        startActivity(intent)
                }
                proButton.setOnClickListener{
                        val intent = Intent(this, ProActivity::class.java)
                        startActivity(intent)
                }
                sauceButton.setOnClickListener {
                        val intent = Intent(this, SauceActivity::class.java)
                        startActivity(intent)
                }
                oilButton.setOnClickListener {
                        val intent = Intent(this, OilActivity::class.java)
                        startActivity(intent)
                }
                noodleButton.setOnClickListener {
                        val intent = Intent(this, NoodleActivity::class.java)
                        startActivity(intent)
                }
                etcButton.setOnClickListener {
                        val intent = Intent(this, EtcActivity::class.java)
                        startActivity(intent)
                }

                TorefButton.setOnClickListener {
                        finish() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
                }
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean { //뒤로가기 액션
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