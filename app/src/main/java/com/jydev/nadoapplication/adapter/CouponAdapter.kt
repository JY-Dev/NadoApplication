package com.jydev.nadoapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.activity_fitness_info.view.*
import kotlinx.android.synthetic.main.coupon_item.view.*
import kotlinx.android.synthetic.main.pt_tutor_item.view.*

class CouponAdapter(context: Context) : BaseAdapter() {
    private val mContext = context
    private val data = mutableListOf(R.drawable.coupon01,R.drawable.coupon02,R.drawable.coupon03)

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1?:LayoutInflater.from(mContext).inflate(R.layout.coupon_item,null)
        view.coupon_img.setImageResource(data[p0])
        return view
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return 0
    }
}