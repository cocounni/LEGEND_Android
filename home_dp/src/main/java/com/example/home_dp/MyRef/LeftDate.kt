package com.example.home_dp.MyRef

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class LeftDate {
    @SuppressLint("SimpleDateFormat")
    fun Cal_Date(input_enddate: String): Long {
        val dateFormat = SimpleDateFormat("yyyyMMdd")

        val endDate = dateFormat.parse(input_enddate)!!.time
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time.time

        val ing_editdate = (endDate - today) / (24 * 60 * 60 * 1000)

        return ing_editdate
    }

    //Cal_Date함수에 들어가기 위해서 5 -> 05로 받음
    fun Cal_Date_len1(input_size1_date : String):String{

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
    fun Cat_ing_editdate(input_ing_editdate: Long):String{

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
}