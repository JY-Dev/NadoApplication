package com.jydev.nadoapplication.util

import android.content.Context
import android.view.View
import android.widget.Toast

object OnClickUtil {
    fun setOnClick(view: View , context : Context){
        view.setOnClickListener {
            Toast.makeText(context,"서비스 준비중입니다.", Toast.LENGTH_SHORT).show()
        }
    }
}