package com.jydev.nadoapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.pt_tutor_item.view.*

class PtTutorAdapter(context: Context) : BaseAdapter() {
    private val mContext = context
    private val data = mutableListOf(Pair("마동석","안녕하세요 2019년 머슬매니아 대회 3위로 입상한 최고의 PT강사 마동석입니다"),
        Pair("김미나","안녕하세요 여성 PT전문가 김미나입니다. 체계적인 관리로 여러분들의 건강을 책임지겠습니다.") , Pair("홍길동","다이어트는 제가 책임지겠습니다. 언제든지 제게 문의해 주세요"))

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1?:LayoutInflater.from(mContext).inflate(R.layout.pt_tutor_item,null)
        view.name_tv.text = data[p0].first
        view.des_tv.text = data[p0].second
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