package com.example.main_dp.selectfcts

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.collections.HashMap

class exist_indata {
    private val user = FirebaseAuth.getInstance().currentUser // 현재 로그인된 사용자의 정보
    private val uid = user?.uid

    fun existdata(data: HashMap<String, String>, overlap:List<String>, context: Context) {
        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
        var const = 0
        db.collection(uid + "UserSelect")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    if (document.data["id"] == data["id"] && "menuname" in document.data
                        && document.data["menuname"] == data["menuname"]){
                        Toast.makeText(context,
                            "이미 ${data["menuname"]}(이/가) 내 냉장고에 있습니다.",
                            Toast.LENGTH_SHORT).show()
                        const = 1
                    }
                }
                if (const == 0){
                    addData().addData(data, overlap, context)
                }
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("MainActivity", "Error getting documents: $exception")
            }
    }
}