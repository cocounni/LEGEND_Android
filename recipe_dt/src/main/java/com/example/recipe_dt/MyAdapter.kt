package com.example.recipe_dt

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.map_dp.MapsActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MyAdapter(val context: Context, val list: ArrayList<Ingre>):
    RecyclerView.Adapter<MyAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recip_ingre, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position], context)

        holder.itemView.setOnClickListener {
            val itemname_list = listOf("조기", "오징어", "명태", "애호박",  "배",
                "닭고기", "동태", "고등어", "무",  "상추",  "배추", "쇠고기", "오이", "사과",
                "돼지고기", "달걀", "양파", "호박")
            var itemname = holder.itemView.findViewById<TextView>(R.id.ingreName).text.toString()

            if (itemname == "애호박(속살)"){
                itemname = "애호박"
            }
            else if (itemname in listOf("닭", "닭살", "닭가슴살")){
                itemname = "닭고기"
            }
            else if (itemname == "동태살"){
                itemname = "동태"
            }
            else if (itemname in listOf("총각무", "무즙", "무채", "래디쉬", "육수용 무")){
                itemname = "무"
            }
            else if (itemname in listOf("배춧잎", "풋배추", "배추잎", "얼갈이배추", "절인 배추")){
                itemname = "상추"
            }
            else if (itemname in listOf("소고기", "쇠고기(힘줄없는부위)", "쇠고기(안심 또는 등심)")){
                itemname = "쇠고기"
            }
            else if (itemname == "백오이"){
                itemname = "오이"
            }
            else if (itemname == "사과즙"){
                itemname = "사과"
            }
            else if (itemname in listOf("돼기고기", "돼지 볼살")){
                itemname = "돼지고기"
            }
            else if (itemname in listOf("계란", "계란흰자", "계란노른자", "달걀노른자", "달걀", "삶은계란", "계란후라이", "달걀")){
                itemname = "달걀"
            }
            else if (itemname in listOf("다진양파", "양파즙")){
                itemname = "양파"
            }
            else if (itemname in listOf("청동호박", "호박잎", "둥근호박")){
                itemname = "호박"
            }

            if (itemname in itemname_list){
                val intent = Intent(holder.itemView.context, MapsActivity::class.java)
                intent.putExtra("ItemName", itemname)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            }
            else{
                Toast.makeText(context, "가격 정보 데이터를 업데이트 중입니다.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val ingrePhoto = itemView?.findViewById<ImageView>(R.id.ingreImg)
        val ingreName = itemView?.findViewById<TextView>(R.id.ingreName)
        val db_firestore = FirebaseFirestore.getInstance()

        fun bind(ingre: Ingre, context: Context){
            if (ingre.photo != "") {
                val resourceId = context.resources.getIdentifier(ingre.photo, "drawable", context.packageName)
                ingrePhoto?.setImageResource(resourceId)
            } else {
                ingrePhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            ingreName?.text = ingre.name


            /////////////////////////////// 재료 유무에 따른 UI 구분하기 ///////////////////////////////
            var user_ing_list = arrayListOf<String>()
            val ing_list = arrayListOf<String>()     ///IngPhoto 에서 받은 ing 이름들 리스트



            ///////////////////////// SQLite 데이터 받기
            val db_sqlite = DataBaseHelper(context = context).readableDatabase //sql 인스턴스 선언

            // RECIPE_ID예시로 선택한다음 레시피에 들어가는 재료 받기
            val choiceingre =
                "select RECIPE_ID, IRDNT_NM from recipe_ingredient where RECIPE_ID in ('97');"

            //////////////////////////////////////// 재료받기 ////////////////////////////////////////////////////////
            val carrot = R.drawable.icon_carrot
            val cursor = db_sqlite.rawQuery(choiceingre, null)

            /// UserSelect

            val user = FirebaseAuth.getInstance().currentUser
            val uid = user?.uid
            db_firestore.collection(uid + "UserSelect")
                .get()
                .addOnSuccessListener { result_UserSelect ->
                    for (document_user in result_UserSelect) {
                        var user_ing_name = document_user.data["menuname"].toString()
                        user_ing_list.add(user_ing_name)

                    }

                    println("for")
                    println(user_ing_list)

                    cursor.run {
                        while (moveToNext()) {
                            val RECIPE_ID = cursor.getString(0)
                            val IRDNT_NM = cursor.getString(1)

                            Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                            Log.w("레시피_IRDNT_NM : ", IRDNT_NM)

                            println(user_ing_list)

                        }
                    }

                    if (ingrePhoto != null) {
                        if (ingre.name !in user_ing_list) {
                            ingrePhoto.setBackgroundColor(Color.parseColor("#80959595"))
                        }
                    }
                }

            }
        }
    }

