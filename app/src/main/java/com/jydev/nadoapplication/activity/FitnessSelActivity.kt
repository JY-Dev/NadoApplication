package com.jydev.nadoapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.app_sub_toolbar.*

class FitnessSelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_sel)

        back_btn.setOnClickListener {
            val intent = Intent()
            setResult(2000,intent)
            finish()
        }
    }
}