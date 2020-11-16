package com.jydev.nadoapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.noti_item.view.*

class NotiAdapter(context: Context) : BaseAdapter() {
    private val mContext = context
    private val data =  mutableListOf(Triple("임시 휴무 공지","안녕하세요 GYM피트니스센터입니다. 9월9일~9월14일까지 추석연휴로 임시 휴무 공지드립니...","2019.05.11"),
        Triple("보수공사 안내","안녕하세요 GYM피트니스센터입니다. 8월17일~8월18일까지 센터 보수공사가 진행됩니다","2019.05.11") ,
        Triple("신규 프로그램 안내","안녕하세요 GYM피트니스센터입니다. 8월5일~8월30일까지 신규 프로그램이 무료로 제공됩니다","2019.05.11")
    )

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1?:LayoutInflater.from(mContext).inflate(R.layout.noti_item,null)
        view.title_tv.text = data[p0].first
        view.des_tv.text = data[p0].second
        view.date_tv.text = data[p0].third
        return view
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}