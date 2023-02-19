package com.example.recipe_dt

import android.content.Context
import android.media.AudioManager
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.recipe_main.*
import java.util.*
import kotlin.concurrent.timer

class RecipeActivity : AppCompatActivity() {
    val explainlist = arrayListOf<Recipe>() //상세레시피 사진,설명 리스트

    ////// 상세레시피 타이머 만들기
    private var  time=0  //시간
    private var timerTask: Timer? = null
    private var isRunning = false //play=true, pause=false

    lateinit var minTextView: TextView
    lateinit var secTextView: TextView
    lateinit var timerSettingButton: Button
    lateinit var inputEditText: EditText


    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_main)

        val getintent = getIntent()
        val recipe_Id = getintent.getStringExtra("recipeId").toString()

        //화면꺼짐방지
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    /// 상세레시피 타이머

    minTextView = findViewById(R.id.minTextView)
    secTextView = findViewById(R.id.secTextView)
    timerSettingButton = findViewById(R.id.timerSettingButton)
    inputEditText = findViewById(R.id.inputEditText)

    val alarm: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
    val ringtone = RingtoneManager.getRingtone(applicationContext, alarm)

    timerSettingButton.setOnClickListener{
        if(inputEditText.text.toString().toInt() != 0) {
            //timer(타이머)
            time = inputEditText.text.toString().toInt()*60
            timerTask = timer(period = 1000) {
                //워커스레드 (UI조작 불가)
                time--
                var min = time / 60
                var sec = time % 60

                runOnUiThread { //메인스레드 (UI조작 가능)
                    //"특정 동작을 UI스레드에서 동작하도록
                    minTextView.text = "$min"
                    secTextView.text = "$sec"
                }
                if (time==0) {
                    runOnUiThread {
                        minTextView.text = "0"
                        secTextView.text = "0"
                        timerTask?.cancel() //타이머 취소
                    }
                    ringtone.streamType = AudioManager.STREAM_ALARM    //핸드폰 소리모드 아닐때도 알림은 소리 on
                    ringtone.play()
                }
                //버튼 지정
                val timeroff = findViewById<Button>(R.id.timeroff)
                //클릭리스너
                timeroff.setOnClickListener {
                    ringtone.stop()
                }
            }
        }

//        타이머 키보드 내리기
        inputEditText.setOnEditorActionListener{ textView, action, event ->
            var handled = false

            if (action == EditorInfo.IME_ACTION_DONE) {
                // 키보드 내리기
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(inputEditText.windowToken, 0)
                handled = true
            }

            handled
        }
    }


        val rAdapter = RecipeAdapter(this, explainlist)
        recyclerView_explain.adapter = rAdapter

        val gm = GridLayoutManager(this, 1)
        recyclerView_explain.layoutManager = gm
        recyclerView_explain.setHasFixedSize(true)

        ////////////////// SQLite 데이터 받기
        val db_sqlite = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

        // 1차 추천으로 나온 메뉴 + 해당 메뉴 상세레시피 (RECIPE_ID로 예시 몇개 뽑아서 테스트 중)
        val filtermenu = "select RECIPE_ID, COOKING_DC, stre_step_image_url from recipe_description where RECIPE_ID in ("+recipe_Id+");"


        val url = "https://cdn-icons-png.flaticon.com/512/649/649395.png"

        val cursor = db_sqlite.rawQuery(filtermenu, null)
        cursor.run{
            while(moveToNext()) {
                val RECIPE_ID = cursor.getString(0)
                val COOKING_DC = cursor.getString(1)
                var stre_step_image_url :String
               if (cursor.getString(2) != null ){
                    stre_step_image_url = cursor.getString(2)
                }
                else{
                    stre_step_image_url = url
                }


                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                Log.w("레시피_COOKING_DC : ", COOKING_DC)


                val available_explain = Recipe(stre_step_image_url, COOKING_DC, RECIPE_ID)
                explainlist.add(available_explain)

                rAdapter.notifyDataSetChanged() //리사이클러뷰 갱신

            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}