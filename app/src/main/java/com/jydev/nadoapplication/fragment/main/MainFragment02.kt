package com.jydev.nadoapplication.fragment.main

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.activity.HealthDataRegActivity
import com.jydev.nadoapplication.data.*
import com.jydev.nadoapplication.util.ViewModelCase
import com.jydev.nadoapplication.viewmodel.BodyDataViewModel
import kotlinx.android.synthetic.main.fragment_main02.view.*
import kotlinx.android.synthetic.main.fragment_main02.view.age_tv
import kotlinx.android.synthetic.main.fragment_my_page.*
import kotlinx.android.synthetic.main.fragment_my_page.view.*
import kotlinx.android.synthetic.main.sub_bottom_item.view.*
import kotlinx.android.synthetic.main.sub_title_item.view.*
import kotlinx.android.synthetic.main.sub_top_item.view.*
import kotlinx.android.synthetic.main.sub_top_item.view.sub_title_tv
import kotlinx.android.synthetic.main.sub_top_item.view.sub_value_tv
import java.text.SimpleDateFormat
import java.util.*

class MainFragment02() : Fragment() {

    private lateinit var subView: LinearLayout
    private lateinit var titleArray: Array<String>
    private lateinit var subItemList: MutableList<Array<String>>
    private val mockDataCondition01 = InBodyData(120F,30F,45F,115F,15F,6.5F)
    private val mockDataCondition02 = FatData(55F,0F,1.5F,0F)
    private val mockDataCondition03 = HrBp(120F,0F,0F)
    private lateinit var mockDataString01: Array<String>
    private lateinit var mockDataString02: Array<String>
    private lateinit var mockDataString03: Array<String>
    private lateinit var heightTv : TextView
    private lateinit var ageTv : TextView
    var height = 0F
    private lateinit var mContext : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelCase.model.body.observe(this, androidx.lifecycle.Observer {
            clearItem()

            addItem(it.inBodyData,it.fatData,it.muscleFatControll,it.hrBp)
            heightTv.text = it.height.toString()+"cm"
            ageTv.text = ViewModelCase.model.getBody()?.age?.toInt().toString()+"세"
        })
    }

    init {
        retainInstance = true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }



    private fun arrayInit() {
        titleArray = getStringArray(R.array.mainSubItemList)
        mockDataString01 = getStringArray(R.array.subvaluetitle01)
        mockDataString02 = getStringArray(R.array.subvaluetitle02)
        mockDataString03 = getStringArray(R.array.subvaluetitle03)
        subItemList = mutableListOf(
            getStringArray(R.array.masinSub01), getStringArray(R.array.masinSub02)
            , getStringArray(R.array.masinSub03), getStringArray(R.array.masinSub04)
        )

        val body = ViewModelCase.model.getBody()
        if(body!=null){
            height = body.height
            addItem(body.inBodyData,body.fatData,body.muscleFatControll,body.hrBp)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main02, container, false)
        view.sub_value_tv.text = height.toString()+"cm"
        subView = view.findViewById(R.id.sub_view)
        heightTv = view.findViewById(R.id.sub_value_tv)
        ageTv = view.findViewById(R.id.age_tv)
        view.age_tv.text = ViewModelCase.model.getBody()?.age?.toInt().toString()+"세"
        view.more_btn.setOnClickListener {
            startActivity(Intent(mContext,HealthDataRegActivity::class.java))
        }
        view.findViewById<TextView>(R.id.date_tv).setDate(Calendar.getInstance().time)
        arrayInit()

        return view
    }

    private fun getStringArray(id: Int): Array<String> = resources.getStringArray(id)

    private fun clearItem() {
        subView.removeAllViews()
    }

    private fun addItem(inbodyData: InBodyData,fatData: FatData,muscleFatControll: MuscleFatControll,hrBp: HrBp) {
        for (i in titleArray.indices) {
            val array = subItemList[i]
            addSubMainTitle(titleArray[i])
            for (position in array.indices) {
                when (i) {
                    0 -> addSubItem01(position, array, inbodyData)
                    1 -> addSubItem02(position, array, fatData)
                    2 -> addSubItem03(position, array, muscleFatControll)
                    3 -> addSubItem04(position, array, hrBp)
                }
            }
        }
    }

    private fun addSubItem01(
        position: Int,
        titleArray: Array<String>,
        inbodyData: InBodyData
    ) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        val bottomView = LayoutInflater.from(context).inflate(R.layout.sub_bottom_item, null)
        topView.sub_title_tv.text = titleArray[position]
        topView.sub_value_title_tv.text = mockDataString01[position]
        when(position){
            0 -> {
                topView.sub_value_tv.text = inbodyData.weight.toString() +"kg"
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockDataCondition01.weight,inbodyData.weight)
                }
            }
            1 -> {
                topView.sub_value_tv.text = inbodyData.fatMass.toString()+"kg"
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockDataCondition01.fatMass,inbodyData.fatMass)
                }
            }
            2 -> {
                topView.sub_value_tv.text = inbodyData.muscles.toString()+"kg"
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockDataCondition01.muscles,inbodyData.muscles)
                }
            }
            3 -> {
                topView.sub_value_tv.text = inbodyData.water.toString()+"kg"
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockDataCondition01.water,inbodyData.water)
                }
            }
            4 -> {
                topView.sub_value_tv.text = inbodyData.protein.toString()+"%"
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockDataCondition01.protein,inbodyData.protein)
                }
            }
            5 -> {
                topView.sub_value_tv.text = inbodyData.mineral.toString()+"kg"
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(bottomView.item_line.width,mockDataCondition01.mineral,inbodyData.mineral)
                }
            }
        }
        topView.bottom_layer.addView(bottomView)
        subView.addView(topView)
    }

    private fun addSubItem02(
        position: Int,
        titleArray: Array<String>,
        fatData: FatData
    ) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        val bottomView = LayoutInflater.from(context).inflate(R.layout.sub_bottom_item, null)
        topView.sub_title_tv.text = titleArray[position]
        when (position) {
            0, 3 -> topView.sub_value_title_tv.text = mockDataString02[position]
        }
        when (position) {
            0 -> topView.sub_value_tv.text = fatData.bmi.toString()
            1 -> topView.sub_value_tv.text = fatData.fatMass.toString() + "kg"
            2 -> topView.sub_value_tv.text = fatData.stomachFat.toString()
            3 -> topView.sub_value_tv.text = fatData.bmr.toString()
        }
        when (position) {
            0 -> {
                bottomView.item_line.setImageResource(R.drawable.sub_bottom_item_line_bmi)
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(
                        bottomView.item_line.width,
                        mockDataCondition02.bmi,
                        fatData.bmi
                    )
                }
            }
            2 -> {
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(
                        bottomView.item_line.width,
                        mockDataCondition02.stomachFat,
                        fatData.stomachFat
                    )
                }
            }
            else -> bottomView.visibility = View.GONE

        }

        topView.bottom_layer.addView(bottomView)
        subView.addView(topView)
    }

    private fun addSubItem03(
        position: Int,
        titleArray: Array<String>,
        muscleFatControll: MuscleFatControll
    ) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        topView.bottom_layer.visibility = View.GONE
        topView.sub_title_tv.text = titleArray[position]
        when(position){
            0 -> {
                topView.sub_value_tv.apply {
                    if (muscleFatControll.fat > 0) {
                        text = "+" + muscleFatControll.fat.toString() + "kg"
                        setTextColor(Color.BLUE)
                    } else {
                        text = muscleFatControll.fat.toString() + "kg"
                        setTextColor(Color.RED)
                    }
                }
            }
            1 -> {
                topView.sub_value_tv.apply {
                    if (muscleFatControll.muscles > 0) {
                        text = "+" + muscleFatControll.muscles.toString() + "kg"
                        setTextColor(Color.BLUE)
                    } else {
                        text = muscleFatControll.muscles.toString() + "kg"
                        setTextColor(Color.RED)
                    }
                }
            }
            2 -> {
                topView.sub_value_tv.apply {
                    if (muscleFatControll.weight > 0) {
                        text = "+" + muscleFatControll.weight.toString() + "kg"
                        setTextColor(Color.BLUE)
                    } else {
                        text = muscleFatControll.weight.toString() + "kg"
                        setTextColor(Color.RED)
                    }
                }
            }
        }

        subView.addView(topView)
    }

    private fun addSubItem04(
        position: Int,
        titleArray: Array<String>,
        hrBp: HrBp
    ) {
        val topView = LayoutInflater.from(context).inflate(R.layout.sub_top_item, null)
        val bottomView = LayoutInflater.from(context).inflate(R.layout.sub_bottom_item, null)
        topView.sub_title_tv.text = titleArray[position]
        topView.sub_value_title_tv.text = mockDataString03[position]
        when (position) {
            0 -> topView.sub_value_tv.text = hrBp.hp.toString() + "bpm"
            1 -> topView.sub_value_tv.text = hrBp.conBp.toString() + "mmHg"
            2 -> topView.sub_value_tv.text = hrBp.relBp.toString() + "mmHg"
        }
        when (position) {
            0 -> {
                bottomView.item_line.viewTreeObserver.addOnGlobalLayoutListener {
                    bottomView.item_arrow.setArrowPosition(
                        bottomView.item_line.width,
                        mockDataCondition03.hp,
                        hrBp.hp
                    )
                }
            }
            else -> bottomView.visibility = View.GONE
        }

        topView.bottom_layer.addView(bottomView)
        subView.addView(topView)
    }

    private fun addSubMainTitle(title: String) {
        val view = LayoutInflater.from(context).inflate(R.layout.sub_title_item, null)
        view.sub_main_title_tv.text = title
        subView.addView(view)
    }

    fun TextView.setDate(date: Date) =
        setText(SimpleDateFormat("yyyy.M.dd", Locale.KOREA).format(date))

    private fun ImageView.setArrowPosition(width: Int, max: Float, value: Float) {
        x = width * (value / max)
    }

}