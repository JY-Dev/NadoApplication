package com.jydev.nadoapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.util.ViewModelCase
import kotlinx.android.synthetic.main.activity_health_data_reg.*
import kotlinx.android.synthetic.main.app_sub_toolbar.*

class HealthDataRegActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_data_reg)
        layoutInit()
    }

    private fun layoutInit(){
        toolbar_title.text ="건강 데이터 등록"
        finish_btn.visibility = View.GONE
        back_btn.setOnClickListener {
            finish()
        }
        val body = ViewModelCase.model.getBody()
        if(body!=null){
            height_et.setText(body.height.toString())
            age_et.setText("28")
        }
    }
}