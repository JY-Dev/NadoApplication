package com.jydev.nadoapplication.fragment.fitness

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.adapter.CouponAdapter
import kotlinx.android.synthetic.main.fragment_coupon.view.*


class CouponFragment : Fragment() {

    private lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_coupon, container, false)
        val adapter = CouponAdapter(mContext)
        view.list_view.adapter = adapter
        view.coupon_num_tv.text = adapter.count.toString()+"개"
        return view
    }


}