package com.jydev.nadoapplication.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.customview.widget.ViewDragHelper
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.sub_bottom_item.view.*
import kotlinx.android.synthetic.main.sub_title_item.view.*
import kotlinx.android.synthetic.main.sub_top_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class MainFragment02 : Fragment() {

    private lateinit var subView: LinearLayout
    private lateinit var titleArray: Array<String>
    private lateinit var subItemList : MutableList<Array<String>>
    private val mockData01 : MutableList<Pair<Float,Float>> = mutableListOf(Pair(70.2F,120F), Pair(13.5F,30F), Pair(22.5F,45F), Pair(57.5F,115F), Pair(8.5F,15F), Pair(3.2F,6.5F))
    private val mockData02 : MutableList<Pair<Float,Float>> = mutableListOf(Pair(22.5F,55F), Pair(13.5F,0F), Pair(0.83F,1.5F), Pair(1725F,0F))
    private val mockData03 : MutableList<Float> = mutableListOf(-3.7f,8.1f,-4.4f)
    private val mockData04 : MutableList<Pair<Float,Float>> = mutableListOf(Pair(62F,120F), Pair(112F,0F), Pair(79F,0F))
    private lateinit var mockDataString01 : Array<String>
    private lateinit var mockDataString02 : Array<String>
    private lateinit var mockDataString03 : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arrayInit()
    }

    private fun arrayInit(){
        titleArray = getStringArray(R.array.mainSubItemList)
        mockDataString01 = getStringArray(R.array.subvaluetitle01)
        mockDataString02 = getStringArray(R.array.subvaluetitle02)
        mockDataString03 = getStringArray(R.array.subvaluetitle03)
        subItemList = mutableListOf(getStringArray(R.array.masinSub01),getStringArray(R.array.masinSub02)
            ,getStringArray(R.array.masinSub03),getStringArray(R.array.masinSub04))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main02, container, false)
        subView = view.findViewById(R.id.sub_view)
        view.findViewById<TextView>(R.id.date_tv).setDate(Calendar.getInstance().time)

        for (i in titleArray.indices){
            val array = subItemList[i]
            addSubMainTitle(titleArray[i])
            for(position in array.indices){
                when(i){
                    0 -> addSubItem01(position,array,mockData01)
                    1 -> addSubItem02(position,array,mockData02)
                    2 -> addSubItem03(position,array,mockData03)
                    3 -> addSubItem04(position,array,mockData04)
                }
            }
        }


        return view
    }

    private fun getStringArray(id : Int): Array<String> = resources.getStringArray(id)

    private fun addSubItem01(position: Int,titleArray : Array<String> , mockData : MutableList<Pair<Float,Float>>) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        val bottomView = LayoutInflater.from(context).inflate(R.layout.sub_bottom_item, null)
        topView.sub_title_tv.text = titleArray[position]
        topView.sub_value_title_tv.text = mockDataString01[position]
        when(position){
            4 -> topView.sub_value_tv.text = mockData[position].first.toString()+"%"
            else -> topView.sub_value_tv.text = mockData[position].first.toString()+"kg"
        }
        bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
            bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockData[position].second,mockData[position].first)
        }
        topView.bottom_layer.addView(bottomView)
        subView.addView(topView)
    }

    private fun addSubItem02(position: Int,titleArray : Array<String> , mockData : MutableList<Pair<Float,Float>>) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        val bottomView = LayoutInflater.from(context).inflate(R.layout.sub_bottom_item, null)
        topView.sub_title_tv.text = titleArray[position]
        when(position){
            0 ,3 -> topView.sub_value_title_tv.text = mockDataString02[position]
        }
        when(position){
            1 -> topView.sub_value_tv.text = mockData[position].first.toString()+"kg"
            else -> topView.sub_value_tv.text = mockData[position].first.toString()
        }
        when(position){
            0 -> {
                bottomView.item_line.setImageResource(R.drawable.sub_bottom_item_line_bmi)
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockData[position].second,mockData[position].first)
                }
            }
            2 -> {
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockData[position].second,mockData[position].first)
                }
            }
            else -> bottomView.visibility = View.GONE

        }

        topView.bottom_layer.addView(bottomView)
        subView.addView(topView)
    }

    private fun addSubItem03(position: Int,titleArray : Array<String> , mockData : MutableList<Float>) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        topView.bottom_layer.visibility = View.GONE
        topView.sub_title_tv.text = titleArray[position]
        topView.sub_value_tv.apply {
            if(mockData[position]>0) {
                text = "+"+mockData[position].toString()+"kg"
                setTextColor(Color.BLUE)
            }
            else {
                text = mockData[position].toString()+"kg"
                setTextColor(Color.RED)
            }
        }
        subView.addView(topView)
    }

    private fun addSubItem04(position: Int,titleArray : Array<String> , mockData : MutableList<Pair<Float,Float>>) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        val bottomView = LayoutInflater.from(context).inflate(R.layout.sub_bottom_item, null)
        topView.sub_title_tv.text = titleArray[position]
        topView.sub_value_title_tv.text = mockDataString03[position]
        when(position){
            0 -> topView.sub_value_tv.text = mockData[position].first.toString()+"bpm"
            else -> topView.sub_value_tv.text = mockData[position].first.toString()+"mmHg"
        }
        when(position){
            0 -> {
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockData[position].second,mockData[position].first)
                }
            }
            else -> bottomView.visibility = View.GONE

        }

        topView.bottom_layer.addView(bottomView)
        subView.addView(topView)
    }

    private fun addSubMainTitle(title : String){
        val view = LayoutInflater.from(context).inflate(R.layout.sub_title_item, null)
        view.sub_main_title_tv.text = title
        subView.addView(view)
    }

    fun TextView.setDate(date: Date) =
        setText(SimpleDateFormat("yyyy.M.dd", Locale.KOREA).format(date))

    private fun ImageView.setArrowPosition(width: Int, max: Float, value: Float) {
            x = width*(value/max)
    }

}