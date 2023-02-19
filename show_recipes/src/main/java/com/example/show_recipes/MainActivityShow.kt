package com.example.show_recipes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivityShow : AppCompatActivity() {

    var recipes_List = ArrayList<menu>() //리사이클러뷰에 들어갈 menu클라스 변수
    val recipes_list_Adatper = RecipesListAdapter(this,recipes_List ) //리사이클러뷰 어뎁터
    lateinit var recyclerView_recipes_list : RecyclerView //메뉴 리사이클러뷰(가로 슬라이드)



    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recommend)
        val dialog = LoadingDialog(this)

//////////리사이클러뷰/////////////////////////////////////////////////////////////////////////////
        recyclerView_recipes_list = findViewById(R.id.recyclerView_recipes_list) //메뉴 리사이클러뷰

        val recipes_linear_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_recipes_list.layoutManager = recipes_linear_manager
        recyclerView_recipes_list.setHasFixedSize(true)

        recyclerView_recipes_list.adapter = recipes_list_Adatper
///////////////////////////////////////////////////////////////////////////////////////////////

//////////STEP1. Firestore 사용자 데이터 받기///////////////////////////////////////////////////////////
        val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언

        //UserSelect컬렉션(사용자 냉장고 재료 데이터)
        var user_refrigerator = ArrayList<ing_id_name_date>() //사용자 냉장고 재료&유통기한 받기
        var user_refrigerator_id_name = ArrayList<ing_id_name>() //사용자 냉장고 재료 id & 이름 받기
        var user_refrigerator_id_date = ArrayList<ing_id_date>() //사용자 냉장고 재료 id & 유통기한 받기
        var user_refrigerator_name = ArrayList<String>() //사용자 냉장고 재료 이름
        var ing_date : String
        dialog.show()
        //UserSelect 데이터 받기
        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid
        db_firestore.collection(uid + "UserSelect") //작업할 컬렉션
            .get() //문서 가져오기
            .addOnSuccessListener { result_UserSelect -> //성공할 경우


                //firebase로부터 사용자 냉장고 재료  받기
                user_refrigerator.clear()

                //Step1. 식재료 유통기한 & 이름 받기
                for (document_ref in result_UserSelect){
                    //user_refrigerator_date 채우기(id & 유통기한)
                    if ("year" in document_ref){
                        println("ing_id : ${document_ref.data["id"]}")
                        //ing_date : 유통기한 변수
                        //Cal_Date_len1 : '5'를 '05'로 받아서 날짜 형식에 맞게 해주는 함수
                        ing_date = Cal_Date_len1(document_ref.data["year"].toString()) +
                                Cal_Date_len1(document_ref.data["month"].toString()) +
                                Cal_Date_len1(document_ref.data["day"].toString())

                        if (ing_date != "nullnullnull") {
                            ing_date = Cat_ing_editdate(Cal_Date(ing_date)) //유통기한 계산 함수, 카테고리화
                        }
                        println("Cat_ing_date : $ing_date")

                        val user_refrigerator_id_date_list = ing_id_date(document_ref.data["id"].toString(), ing_date)
                        user_refrigerator_id_date.add(user_refrigerator_id_date_list)

                    }
                    //user_refrigerator_name 채우기(id & 재료 이름)
                    else if ("menuname" in document_ref){
                        val user_refrigerator_id_name_list = ing_id_name(document_ref.data["id"].toString(),
                            document_ref.data["menuname"].toString())
                        user_refrigerator_id_name.add(user_refrigerator_id_name_list)
                    }

                }


                //최종 user_refrigerator : 같은 id끼리 (id,재료 이름,유통기한) 받아옴
                for (date_cnt : Int in 0..(user_refrigerator_id_date.size-1)){
                    for(name_cnt : Int in 0..(user_refrigerator_id_name.size-1)){
                        if (user_refrigerator_id_name[name_cnt].id == user_refrigerator_id_date[date_cnt].id){
                            var ing_list = ing_id_name_date(
                                user_refrigerator_id_name[name_cnt].id,
                                user_refrigerator_id_name[name_cnt].menuname,
                                user_refrigerator_id_date[date_cnt].date
                            )


                            user_refrigerator.add(ing_list)

                        }
                        else{
                            continue
                        }
                    }
                }

                //sql에 들어갈 재료 이름들 받아옴
                for (ref_cnt : Int in 0..(user_refrigerator.size-1)){
                    val user_refrigerator_name_list = user_refrigerator[ref_cnt].menuname
                    user_refrigerator_name.add(user_refrigerator_name_list)
                }

                println("user_refrigerator.size : ${user_refrigerator.size}")
                println("user_refrigerator_name.size : ${user_refrigerator_name.size}")

////////////////////STEP2.SQLite 레시피 데이터//////////////////////////////////////////////////////////////////////////

                if(user_refrigerator_name.size > 0){ //사용자 냉장고에 재료가 있으면 레시피 추천 시작
                    ///////////SQL 문 안에 집어넣기 위해 변수 조정
                    var sql_user_refrigerator_name = "\"" + "물" + user_refrigerator_name[0] //처음 재료는 먼저 넣어주기
                    //user_refrigerator_name를 sql로 넣기 위해 스트링 변수로 만들어주기
                    //in ()안에 넣기 위해서 ","로 엮어줌
                    for (name_cnt: Int in 1..(user_refrigerator_name.size - 2)){
                        sql_user_refrigerator_name += "\",\"" + user_refrigerator_name[name_cnt]
                    }
                    sql_user_refrigerator_name +=  "\",\"" + user_refrigerator_name[user_refrigerator_name.size - 1] + "\"" //마지막 재료 넣어주기
                    println("sql_user_refrigerator_name : $sql_user_refrigerator_name")
                ///////////


                    val db_sqlite = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

                    //Step2-1. 1차 추천(식재료 50프로 이상 보유시 추천 & 유통기한 빠른 순으로 제공)
                    //Step2-1-1. 레시피 식재료 50프로 이상 보유시 추천하는 레시피 id 받기
                    val sql_1_id = "SELECT info.RECIPE_NM_KO, info.COOKING_TIME, info.RECIPE_ID\n" +
                            "FROM recipe_information info, \n" +
                            "(SELECT ing.RECIPE_ID, count(ing.IRDNT_NM) AS RECIPE_ING_COUNT ,\n" +
                            "count(CASE WHEN ing.IRDNT_NM in (" + sql_user_refrigerator_name +") THEN 1 END) AS ABLE_ING_COUNT\n" +
                            "FROM recipe_ingredient ing\n" +
                            "GROUP BY ing.RECIPE_ID\n" +
                            "ORDER BY count(ing.IRDNT_NM)) user\n" +
                            "WHERE user.RECIPE_ID=info.RECIPE_ID\n" +
                            "and user.ABLE_ING_COUNT >= (user.RECIPE_ING_COUNT)*0.5\n"

                    val cursor_id = db_sqlite.rawQuery(sql_1_id,null)
                    var recipe_id_list = mutableSetOf<String>() //고유 recipe id

                    cursor_id.run{

                        while(moveToNext()){

                            val RECIPE_ID_info = cursor_id.getString(2)

                            recipe_id_list.add(RECIPE_ID_info)
                            println("recipe_id_list : ${recipe_id_list}")
                        }
                    }

                    //Step2-1-2. Firebase의 식재료 유통기한과 DB의 레시피 재료를 비교하여 유통기한 빠른 순으로 정렬


                    val sql_1_irdnt_date = "SELECT ing.RECIPE_ID, ing.IRDNT_NM, user.RECIPE_ING_COUNT, info.RECIPE_NM_KO, user.ABLE_ING_COUNT, info.COOKING_TIME, info.IMG_URL, info.RECIPE_ID,\n" +
                            "info.NATION_NM, info.LEVEL_NM\n" +
                            "FROM recipe_information info, recipe_ingredient ing,\n" +
                            "(SELECT ing.RECIPE_ID, count(ing.IRDNT_NM) AS RECIPE_ING_COUNT ,\n" +
                            "count(CASE WHEN ing.IRDNT_NM in (" + sql_user_refrigerator_name +") THEN 1 END) AS ABLE_ING_COUNT\n" +
                            "FROM recipe_ingredient ing\n" +
                            "GROUP BY ing.RECIPE_ID\n" +
                            "ORDER BY count(ing.IRDNT_NM)) user\n" +
                            "WHERE user.RECIPE_ID=info.RECIPE_ID and info.RECIPE_ID=ing.RECIPE_ID\n" +
                            "and user.ABLE_ING_COUNT >= (user.RECIPE_ING_COUNT)*0.5\n"


                    //유통기한 조건
                    val cursor_irdnt_date_list = db_sqlite.rawQuery(sql_1_irdnt_date,null)
                    var IRDNT_NM_ing_list = arrayListOf<String>()


                    cursor_irdnt_date_list.run{

                        while(moveToNext()){

                            recipe_id_list.forEach{

                                if (cursor_irdnt_date_list.getString(0) == it){ //id가 같을때
                                    val irdnt_nm_ing_list = cursor_irdnt_date_list.getString(1) //재료를 받아오는데
                                    IRDNT_NM_ing_list.add(irdnt_nm_ing_list)
                                    if(IRDNT_NM_ing_list.size.toString() == cursor_irdnt_date_list.getString(2)){ //해당 id의 레시피 재료 개수랑 같아지면
                                        val REAL_IRDNT_NM_ing_list = IRDNT_NM_ing_list //해당 id의 레시피 재료를 다 받았움!


                                        var ing_editdate_hurry_cnt = 0
                                        var ing_editdate_good_cnt = 0
                                        var ing_editdate_enough_cnt = 0

                                        for (index:Int in 0..(user_refrigerator.size-1)){

                                            if (user_refrigerator[index].menuname in REAL_IRDNT_NM_ing_list){

                                                if(user_refrigerator[index].date == "급함"){
                                                    ing_editdate_hurry_cnt += 1
                                                }
                                                else if (user_refrigerator[index].date == "보통"){
                                                    ing_editdate_good_cnt += 1

                                                }
                                                else if (user_refrigerator[index].date == "여유"){
                                                    ing_editdate_enough_cnt += 1
                                                }

                                            }

                                        }

                                        val RECIPE_NM_KO = cursor_irdnt_date_list.getString(3)
                                        val COOKING_TIME = cursor_irdnt_date_list.getString(5)
                                        val IMG_URL = cursor_irdnt_date_list.getString(6)

                                        val RECIPE_ID = cursor_irdnt_date_list.getString(7) //즐겨찾기를 위한 id

                                        val NATION_NM = cursor_irdnt_date_list.getString(8)
                                        val LEVEL_NM = cursor_irdnt_date_list.getString(9)

                                        val available_recipes_List = menu(IMG_URL, RECIPE_NM_KO , COOKING_TIME,
                                            ing_editdate_hurry_cnt, ing_editdate_good_cnt, ing_editdate_enough_cnt,
                                            RECIPE_ID, NATION_NM, LEVEL_NM)

                                        recipes_List.add(available_recipes_List)
                                        IRDNT_NM_ing_list = arrayListOf<String>() //초기화(다른 레시피 재료 받으러 가자)
                                    }
                                }
                            }
                        }
                    }
                    recipes_List.sortWith(compareBy ({ -it.hurry_cnt }, {-it.good_cnt}, {-it.enough_cnt}))

                    //잘 정렬되었는지 확인하는 용도
                    for (List_cnt : Int in 0..(recipes_List.size -1)){
                        println("recipes_List[menu_name] : ${recipes_List[List_cnt].menu_name}")
                        println("recipes_List[hurry_cnt] : ${recipes_List[List_cnt].hurry_cnt}")
                        println("recipes_List[good_cnt] : ${recipes_List[List_cnt].good_cnt}")
                        println("recipes_List[enough_cnt] : ${recipes_List[List_cnt].enough_cnt}")
                    }

                    update_recipes_list_Adatper()//리사이클러뷰 갱신

//////////////////////STEP.3 2차 추천/////////////////////////////////////////////////////////////////////////////////////////////
                    //추천받기 버튼 누를거라서 체크 해제하는건 고려 일단 안 해도 됨
                    //각 컬럼별로 1차 추천 리스트 셋 저장해둔 다음 체크박스를 누르면 리스트셋 초기화하고 클래스에 다시 추가하는 방식
                    //이렇게되면 다른 컬럼이 체크가 된 게 없더라도 1차 추천 리스트 셋이 초기 상태이므로 교집합해도 원하는대로 출력 가능

                    //2차 추천 변수
                    //country
                    val korea = findViewById<CheckBox>(R.id.korea)
                    val china = findViewById<CheckBox>(R.id.china)
                    val japan = findViewById<CheckBox>(R.id.japan)
                    val western = findViewById<CheckBox>(R.id.western)
                    val etc = findViewById<CheckBox>(R.id.etc)

                    //level
                    val easy = findViewById<CheckBox>(R.id.easy)
                    val normal = findViewById<CheckBox>(R.id.normal)
                    val hard = findViewById<CheckBox>(R.id.hard)

                    //time
                    val short_time = findViewById<CheckBox>(R.id.short_time)
                    val middle_time = findViewById<CheckBox>(R.id.middle_time)
                    val long_time = findViewById<CheckBox>(R.id.long_time)

                    //1차 추천 리스트 받아오는 변수들
                    val recipes_List_1st = recipes_List
                    val recipes_List_1st_set = recipes_List.toMutableSet()
                    var recipes_List_country = recipes_List_1st_set
                    var recipes_List_level = recipes_List_1st_set
                    var recipes_List_time = recipes_List_1st_set


                    //체크박스 선택 후 "추천받기" 클릭시 2차 추천
                    val REC_2_Btn : Button = findViewById(R.id.rec_2_Btn)
                    REC_2_Btn.setOnClickListener{

                        //국가별
                        if(korea.isChecked || china.isChecked || japan.isChecked ||
                            western.isChecked || etc.isChecked){
                            recipes_List_country = mutableSetOf<menu>()
                            for (List_cnt : Int in 0..(recipes_List_1st.size -1)){
                                Log.w("menu_country_for문 시작", recipes_List_country.toString())
                                if (korea.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_country == "한식"){
                                        recipes_List_country.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (china.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_country == "중국") {
                                        recipes_List_country.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (japan.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_country == "일본"){
                                        recipes_List_country.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (western.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_country == "서양" ||
                                        recipes_List_1st[List_cnt].menu_country == "이탈리아"){
                                        recipes_List_country.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (etc.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_country == "동남아시아" ||
                                        recipes_List_1st[List_cnt].menu_country == "퓨전"){
                                        recipes_List_country.add(recipes_List_1st[List_cnt])
                                    }
                                }
                            }
                        }
                        //난이도별
                        if(easy.isChecked || normal.isChecked || hard.isChecked){
                            recipes_List_level = mutableSetOf<menu>()
                            for (List_cnt : Int in 0..(recipes_List_1st.size -1)){
                                Log.w("menu_level_for문 시작", recipes_List_level.toString())
                                if (easy.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_level == "초보환영"){
                                        recipes_List_level.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (normal.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_level == "보통") {
                                        recipes_List_level.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (hard.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_level == "어려움"){
                                        recipes_List_level.add(recipes_List_1st[List_cnt])
                                    }
                                }
                            }
                        }
                        //소요시간별
                        if(short_time.isChecked || middle_time.isChecked || long_time.isChecked){
                            recipes_List_time = mutableSetOf<menu>()
                            for (List_cnt : Int in 0..(recipes_List_1st.size -1)){
                                Log.w("menu_level_for문 시작", recipes_List_time.toString())
                                if (short_time.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_time == "5분" ||
                                        recipes_List_1st[List_cnt].menu_time == "10분" ||
                                        recipes_List_1st[List_cnt].menu_time == "15분" ||
                                        recipes_List_1st[List_cnt].menu_time == "20분" ||
                                        recipes_List_1st[List_cnt].menu_time == "25분" ){
                                        recipes_List_time.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (middle_time.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_time == "30분" ||
                                        recipes_List_1st[List_cnt].menu_time == "35분" ||
                                        recipes_List_1st[List_cnt].menu_time == "40분" ||
                                        recipes_List_1st[List_cnt].menu_time == "50분" ||
                                        recipes_List_1st[List_cnt].menu_time == "60분") {
                                        recipes_List_time.add(recipes_List_1st[List_cnt])
                                    }
                                }
                                if (long_time.isChecked){
                                    if (recipes_List_1st[List_cnt].menu_time == "70분" ||
                                        recipes_List_1st[List_cnt].menu_time == "80분" ||
                                        recipes_List_1st[List_cnt].menu_time == "90분" ||
                                        recipes_List_1st[List_cnt].menu_time == "120분" ||
                                        recipes_List_1st[List_cnt].menu_time == "140분" ||
                                        recipes_List_1st[List_cnt].menu_time == "175분" ||
                                        recipes_List_1st[List_cnt].menu_time == "180분"){
                                        recipes_List_time.add(recipes_List_1st[List_cnt])
                                    }
                                }
                            }
                        }

                        val recipes_List_int1 = recipes_List_country.intersect(recipes_List_level)
                        val recipes_List_int2 = recipes_List_int1.intersect(recipes_List_time)
                        recipes_List = ArrayList(recipes_List_int2)

                        for (List_cnt : Int in 0..(recipes_List.size -1)){
                            Log.w("menu_name", recipes_List[List_cnt].menu_name)
                            Log.w("menu_country" , recipes_List[List_cnt].menu_country)
                            Log.w("menu_level", recipes_List[List_cnt].menu_level)
                            Log.w("menu_time", recipes_List[List_cnt].menu_time)
                        }
                        recipes_List_country = recipes_List_1st_set
                        recipes_List_level = recipes_List_1st_set
                        recipes_List_time = recipes_List_1st_set

                        //(2차추천용)만들 수 있는 총 레시피 개수 출력
                        total_recipe_cnt(recipes_List)

                        update_recipes_list_Adatper()         //리사이클러뷰 갱신

                    }
////////////////////////////////////////////////////////////////////////////////////////////////////

                    //(1차추천용) 만들 수 있는 총 레시피 개수 출력
                    total_recipe_cnt(recipes_List)

                    db_sqlite.close()

                }else {//사용자 재료가 아무것도 없는 경우(예외처리)

                }
                //사용자 냉장고에 재료가 있으면 레시피 추천 시작
                dialog.dismiss()
////////////////////////////////////////////////////////////////////////////////////////////////////

            }
            .addOnFailureListener{exception ->
            //실패할 경우
            Log.w("MainActivity_Error", "UserSelect Error: $exception")
                dialog.dismiss()
            }



////////////////////////////////////////////////////////////////////////////////////////////////////////





    }
    ////////OnCreate 함수 끝/////////

    override fun onStart() {
        super.onStart()
        update_recipes_list_Adatper()
    }


    //유통기한 계산 함수

    //https://ykkdev.tistory.com/8
    private fun Cal_Date(input_enddate: String): Long {

        val dateFormat = SimpleDateFormat("yyyyMMdd")

        val endDate = dateFormat.parse(input_enddate).time
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time.time

        val ing_editdate = (endDate - today) / (24 * 60 * 60 * 1000)

        println("식재료 남은 기간 : ${ing_editdate}")

        return ing_editdate
    }

    //Cal_Date함수에 들어가기 위해서 5 -> 05로 받음
    private fun Cal_Date_len1(input_size1_date : String):String{

        val output_size2_date : String

        if (input_size1_date.length == 1){
            output_size2_date = "0" + input_size1_date
        }
        else {
            output_size2_date = input_size1_date
        }
        return output_size2_date
    }

    //유통기한 기한별로 나누기(0~3일 : 급함, 4~7일 : 보통, 8일~ : 여유)
    private fun Cat_ing_editdate(input_ing_editdate: Long):String{

        val output_ing_editdate : String

        if (input_ing_editdate >= 0 && input_ing_editdate <= 3){ //0,1,2,3일
            output_ing_editdate = "급함"
        }
        else if (input_ing_editdate >= 4 && input_ing_editdate <= 7){//4,5,6,7일
            output_ing_editdate = "보통"
        }
        else if (input_ing_editdate >= 8){ //8일 이상
            output_ing_editdate = "여유"
        }
        else {
            output_ing_editdate = "고려 안 함"
        }

        return output_ing_editdate
    }


    //리사이클러뷰 업데이트
    private fun update_recipes_list_Adatper(){
        val recipes_list_Adatper = RecipesListAdapter(this,recipes_List )
        recyclerView_recipes_list.adapter = recipes_list_Adatper
        recipes_list_Adatper.setData(recipes_List)
        recipes_list_Adatper.notifyDataSetChanged()
    }


    private fun total_recipe_cnt(recipes_List : ArrayList<menu>){
        val total_recipe_cnt = recipes_List.size.toString()
        Log.w("레시피_total_recipe_cnt", total_recipe_cnt)
        val TOTAL_RECIPE_CNT : TextView = findViewById(R.id.total_recipe_cnt_id)
        TOTAL_RECIPE_CNT.text = "총 " + total_recipe_cnt + "개의 레시피가 검색되었습니다."
    }

}