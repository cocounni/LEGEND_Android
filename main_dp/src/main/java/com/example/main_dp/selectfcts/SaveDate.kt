package com.example.main_dp.selectfcts

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEGATIVE
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class SaveDate {
    private val user = FirebaseAuth.getInstance().currentUser // 현재 로그인된 사용자의 정보
    private val uid = user?.uid

    fun AddDate(name:String, id:String, context:Context) {
        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val data_cal = hashMapOf(
            "id" to id
        )
        val date_listener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                data_cal["year"] = year.toString()
                data_cal["month"] = (month + 1).toString()
                data_cal["day"] = dayOfmonth.toString()
                db.collection(uid+"UserSelect")
                    .add(data_cal)
                    .addOnSuccessListener {
                        // 성공할 경우
                        Toast.makeText(context, "${name}(이/가) 추가되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { exception ->
                        // 실패할 경우
                        Log.w("Date", "Error getting documents: $exception")
                    }
            }
        }
        val builder = DatePickerDialog(context, date_listener, year, month, day)
        builder.setTitle("${name}의 유통기한을 입력해주세요.")
        builder.setButton(DatePickerDialog.BUTTON_NEGATIVE,
            "다음에 입력하기",
            DialogInterface.OnClickListener { DatePickerDialog, i -> BUTTON_NEGATIVE
                data_cal["year"] = "-"
                data_cal["month"] = "-"
                data_cal["day"] = "-"
                db.collection(uid+"UserSelect")
                    .add(data_cal)
                    .addOnSuccessListener {
                        // 성공할 경우
                        Toast.makeText(context, "${name}(이/가) 추가되었습니다", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { exception ->
                        // 실패할 경우
                        Log.w("Date", "Error getting documents: $exception")
                    }
            }
        )
        builder.show() //달력 다이얼로그 띄우기
    }
}