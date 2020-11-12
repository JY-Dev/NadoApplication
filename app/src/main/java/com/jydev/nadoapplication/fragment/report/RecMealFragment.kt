package com.jydev.nadoapplication.fragment.report

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.fragment_rec_meal.view.*
import kotlinx.android.synthetic.main.rec_meal_item.*
import kotlinx.android.synthetic.main.rec_meal_item.view.*

class RecMealFragment : Fragment() {
    private lateinit var subView : LinearLayout
    private val dowList = mutableListOf("일요일","월요일","화요일","수요일","목요일","금요일","토요일")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rec_meal, container, false)
        subView = view.sub_view
        dowList.forEach {
            addSubItem(it)
        }
        return view
    }

    private fun addSubItem(dow:String){
        val subitem = LayoutInflater.from(context).inflate(R.layout.rec_meal_item,null)
        subitem.dow_tv.apply {
            text = dow
            when(dow){
                "일요일","토요일" -> setTextColor(Color.RED)
            }
        }
        if(dow=="일요일") {
            subitem.sub_item_view.visibility = View.VISIBLE
            subitem.breakfast_tv.text = "토마토 2개  / 바나나 1개 / 계란 1개 "
            subitem.lunch_tv.text = "현미밥(쌀밥) 반공기 / 고등어 반마리 / 나물 / 옥수수 반개"
            subitem.dinner_tv.text = "현미밥 반공기 / 고구마 1개 / 방울토마토 5개"
        }
        subView.addView(subitem)
    }

}