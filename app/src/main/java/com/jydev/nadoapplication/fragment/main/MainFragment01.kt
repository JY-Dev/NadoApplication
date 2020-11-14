package com.jydev.nadoapplication.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.callback.ClearFragmentCallback
import com.jydev.nadoapplication.util.ViewModelCase
import kotlinx.android.synthetic.main.fragment_main01.view.*
import kotlinx.android.synthetic.main.fragment_my_page.*

class MainFragment01(clearFragmentCallback: ClearFragmentCallback) : Fragment() {
    private val callback = clearFragmentCallback
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
        val view = inflater.inflate(R.layout.fragment_main01, container, false)
        view.pre_btn.setOnClickListener {
            callback.clearFragment()
        }
        ageTv = view.age_tv
        view.age_tv.text = ViewModelCase.model.getBody()?.age?.toInt().toString()+"세"

        return view
    }

}