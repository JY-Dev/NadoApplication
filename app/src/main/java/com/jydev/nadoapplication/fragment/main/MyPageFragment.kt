package com.jydev.nadoapplication.fragment.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.activity.HealthDataRegActivity
import kotlinx.android.synthetic.main.fragment_my_page.view.*

class MyPageFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_page, container, false)
        view.health_reg_btn.setOnClickListener {
            startActivity(Intent(context,HealthDataRegActivity::class.java))
        }
        return view
    }

}