package com.jydev.nadoapplication.fragment.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.activity.HealthDataRegActivity
import com.jydev.nadoapplication.util.ViewModelCase
import com.jydev.nadoapplication.util.ViewModelCase.model
import kotlinx.android.synthetic.main.fragment_my_page.*
import kotlinx.android.synthetic.main.fragment_my_page.view.*

class MyPageFragment : Fragment() {
    private lateinit var ageTv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelCase.model.body.observe(this, Observer {
            ageTv.text = it.age.toInt().toString()+"세"
       })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_page, container, false)
        view.health_reg_btn.setOnClickListener {
            startActivity(Intent(context,HealthDataRegActivity::class.java))
        }
        ageTv = view.age_tv
        view.age_tv.text = model.getBody()?.age?.toInt().toString()+"세"
        return view
    }

}