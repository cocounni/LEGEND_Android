package com.example.recipe_dt

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle


class LoadingDialog(context: Context) : Dialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading)

        //밖에 눌러도 취소 안되게
        setCancelable(false)

        //배경색 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}