package com.jydev.nadoapplication.fragment.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.fragment_rec_meal.view.*
import kotlinx.android.synthetic.main.pt_sub_item.view.*


class PtSubFragment : Fragment() {
    private lateinit var subView : LinearLayout
    private var mockTitle = mutableListOf("추천식단 참조하기","잠자기전 운동하기")
    private var mockDescription = mutableListOf("강민국 회원님 추천식단 참고해서 요일별로 식단관리해 주세요. 지금 체중이 빠져야 되는데 더 늘었으니까 지금부터라도 꼭 추천 식단을 지켜주세요!!","강민국 회원님 등록한 이미지처럼 잠자기 2시간 전에 간단한 운동(스트레칭)한 후에 잠자면 다음날 몸이 많이 가벼워질거에요 앞으로도 파이팅하고 운동시간 늦지 않게 항상 먼저 도착해서 스트레칭부터 시작해 주세요. 최근에 너무 늦게 도착하는 것 같아요 부탁드릴게요 ^^")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pt_sub, container, false)
        subView = view.sub_view
        for(i in 0..1){
            addSubItem(i)
        }

        return view
    }

    private fun addSubItem(position:Int){
        val view = LayoutInflater.from(context).inflate(R.layout.pt_sub_item,null)
        view.pt_sub_item_des_tv.text = mockDescription[position]
        view.sub_title_tv.text = mockTitle[position]
        if (position==1){
            view.pt_sub_item_des_img.setBackgroundResource(R.drawable.sample01)
            view.pt_sub_item_des_img02.setBackgroundResource(R.drawable.sample02)
        }
        subView.addView(view)
    }


}