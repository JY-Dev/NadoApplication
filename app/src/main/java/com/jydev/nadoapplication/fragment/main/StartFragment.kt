package com.jydev.nadoapplication.fragment.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.activity.FitnessSelActivity
import com.jydev.nadoapplication.adapter.GridAdapter
import com.jydev.nadoapplication.util.FirstCheck
import kotlinx.android.synthetic.main.fragment_start.view.*
import kotlinx.android.synthetic.main.start_main_sub_item.view.*


class StartFragment : Fragment() {
    private lateinit var subView : LinearLayout
    private val mockData = mutableListOf("내 주변", "신규 피트니스 센터")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        subView = view.sub_view
        for(i in 0..1){
            addSubItem(i)
        }
        view.center_btn.setOnClickListener {
            startActivityForResult(Intent(context,FitnessSelActivity::class.java),5000)
        }
        return view
    }

    private fun addSubItem(position:Int){
        val view = LayoutInflater.from(context).inflate(R.layout.start_main_sub_item,null)
        view.sub_title_tv.text = mockData[position]
        if(position==0) view.sub_sub_title_tv.visibility = View.GONE
        val adapter = GridAdapter(context!!)
        view.grid_view.adapter = adapter
        view.grid_view.setExpanded(true)
        subView.addView(view)
    }

}