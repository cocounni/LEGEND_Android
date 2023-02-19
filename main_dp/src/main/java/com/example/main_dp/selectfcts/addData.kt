package com.example.main_dp.selectfcts

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class addData {
    private val user = FirebaseAuth.getInstance().currentUser // 현재 로그인된 사용자의 정보
    private val uid = user?.uid

    fun addData(data: HashMap<String, String>, overlap:List<String>, context: Context){
        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
        SaveDate().AddDate(data["menuname"].toString(), data["id"].toString(), context)
        db.collection(uid + "UserSelect")
            .add(data)
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("MainActivity", "Error getting documents: $exception")
            }
        if (overlap[0] != "0"){
            for (i in overlap.indices){
                val data_over = hashMapOf(
                    "photo" to data["photo"],
                    "id" to data["id"],
                    "menuname" to overlap[i],
                    "display" to "0"
                )
                db.collection(uid + "UserSelect")
                    .add(data_over)
                    .addOnFailureListener { exception ->
                        // 실패할 경우
                        Log.w("MainActivity", "Error getting documents: $exception")
                    }
            }
        }
    }
}