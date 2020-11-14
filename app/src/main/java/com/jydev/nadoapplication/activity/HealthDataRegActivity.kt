package com.jydev.nadoapplication.activity

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.setPadding
import com.google.android.material.textview.MaterialTextView
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.data.Body
import com.jydev.nadoapplication.util.ViewModelCase
import com.jydev.nadoapplication.util.ViewModelCase.model
import com.jydev.nadoapplication.util.dp
import kotlinx.android.synthetic.main.activity_health_data_reg.*
import kotlinx.android.synthetic.main.app_sub_toolbar.*
import kotlinx.android.synthetic.main.health_data_reg_item.view.*
import kotlinx.android.synthetic.main.health_data_reg_item_02.*
import kotlin.math.abs

class HealthDataRegActivity() : AppCompatActivity() {
    private val etIdList = mutableListOf<Int>()
    private val firstList = mutableListOf(Pair("신장","cm"), Pair("연령","세"))
    private val secondList = mutableListOf(Pair("체중","kg"), Pair("체지방량","kg"), Pair("골격근량","kg"), Pair("체수분","kg"), Pair("단백질","kg"), Pair("무기질","kg"))
    private val thirdList = mutableListOf(Pair("BMI","kg"), Pair("체지방률","%"), Pair("복부지방률","%"), Pair("기초대사량","kcal"), Pair("심박수","bpm"), Pair("수축기혈압","mmHg"), Pair("이완기혈압","mmHg"))
    private val fourthList = mutableListOf(Pair("지방","kg"), Pair("근육","kg"), Pair("체중","kg"))
    private val dataList = mutableListOf(firstList,secondList,thirdList,fourthList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_data_reg)
        layoutInit()
    }

    private fun layoutInit() {
        toolbar_title.text = "건강 데이터 등록"
        finish_btn.visibility = View.GONE

        val body = ViewModelCase.model.getBody()

        val titleArray = resources.getStringArray(R.array.healthRegItemList)
        titleArray.forEachIndexed { index, title ->
            text_view.addView(getTopView(title))
            getItemView(index)
        }
        text_view.addView(LayoutInflater.from(this).inflate(R.layout.health_data_reg_item_02,null))

        if (body != null) {
            rb_fatmass_minus.isChecked = minusCheck(body.muscleFatControll.fat)
            rb_muscle_minus.isChecked = minusCheck(body.muscleFatControll.muscles)
            rb_weight_minus.isChecked = minusCheck(body.muscleFatControll.weight)
            etIdList.addAll(mutableListOf(fatmass_et.id,muscle_et.id,weight_et.id))
            etIdList.forEachIndexed { index, i ->
                var data = 0f
                when(index){
                    0 -> data = body.height
                    1 -> data = body.age
                    2 -> data = body.inBodyData.weight
                    3 -> data = body.inBodyData.fatMass
                    4 -> data = body.inBodyData.muscles
                    5 -> data = body.inBodyData.water
                    6 -> data = body.inBodyData.protein
                    7 -> data = body.inBodyData.mineral
                    8 -> data = body.fatData.bmi
                    9 -> data = body.fatData.fatMass
                    10 -> data = body.fatData.stomachFat
                    11 -> data = body.fatData.bmr
                    12 -> data = body.hrBp.hp
                    13 -> data = body.hrBp.conBp
                    14 -> data = body.hrBp.relBp
                    15 -> data = abs(body.muscleFatControll.fat)
                    16 -> data = abs(body.muscleFatControll.muscles)
                    17 -> data = abs(body.muscleFatControll.weight)
                }
                setEditData(i,data.toString())
            }

        }
        complete_btn.setOnClickListener {
            if(allEtBlankCheck()&&body!=null){
                etIdList.forEachIndexed { index, id ->
                    val et = findViewById<EditText>(id)
                    when(index){
                        0 -> body.height = et.text.toString().toFloat()
                        1 -> body.age = et.text.toString().toFloat()
                        2 -> body.inBodyData.weight = et.text.toString().toFloat()
                        3 -> body.inBodyData.fatMass = et.text.toString().toFloat()
                        4 -> body.inBodyData.muscles = et.text.toString().toFloat()
                        5 -> body.inBodyData.water = et.text.toString().toFloat()
                        6 -> body.inBodyData.protein = et.text.toString().toFloat()
                        7 -> body.inBodyData.mineral = et.text.toString().toFloat()
                        8 -> body.fatData.bmi = et.text.toString().toFloat()
                        9 -> body.fatData.fatMass = et.text.toString().toFloat()
                        10 -> body.fatData.stomachFat = et.text.toString().toFloat()
                        11 -> body.fatData.bmr = et.text.toString().toFloat()
                        12 -> body.hrBp.hp = et.text.toString().toFloat()
                        13 -> body.hrBp.conBp = et.text.toString().toFloat()
                        14 -> body.hrBp.relBp = et.text.toString().toFloat()
                        15 -> body.muscleFatControll.fat = if(!rb_fatmass_minus.isChecked) et.text.toString().toFloat() else -et.text.toString().toFloat()
                        16 -> body.muscleFatControll.muscles = if(!rb_muscle_minus.isChecked) et.text.toString().toFloat() else -et.text.toString().toFloat()
                        17 -> body.muscleFatControll.weight = if(!rb_weight_minus.isChecked) et.text.toString().toFloat() else -et.text.toString().toFloat()
                    }
                    model.setBody(body)
                }
                finish()
            }
            else Toast.makeText(this,"모든 항목을 채워주세요.",Toast.LENGTH_SHORT).show()
        }
    }

    private fun minusCheck(data : Float) = (data < 0)

    private fun allEtBlankCheck() : Boolean{
        var flag = true
        etIdList.forEach {
            if(findViewById<EditText>(it).text.isEmpty()) flag = false
        }
        return flag
    }

    private fun setEditData(id:Int,data:String){
        findViewById<EditText>(id).setText(data)
    }

    private fun getTopView(title:String): TextView {
        return TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            setPadding(10.dp)
            setTextColor(resources.getColor(R.color.text_color, null))
            setBackgroundColor(Color.parseColor("#f4f6fa"))
            setTextSize(TypedValue.COMPLEX_UNIT_DIP,14f)
            text = title
        }
    }

    private fun getItemView(index:Int){
        val rl = LinearLayout(this)
        rl.apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            setPadding(30.dp,20.dp,20.dp,20.dp)
        }
        dataList[index].forEach {
            rl.addView(getSubItem(it.first,it.second))
        }
        text_view.addView(rl)
    }

    private fun getSubItem(title:String,unit:String):View{
        val view = LayoutInflater.from(this).inflate(R.layout.health_data_reg_item,null)
        view.sub_title_tv.apply {
            text = title
            id = ViewCompat.generateViewId()
        }
        view.unit_tv.apply {
            text = unit
            id = ViewCompat.generateViewId()
        }
        view.data_et.apply {
            val etId = ViewCompat.generateViewId()
            etIdList.add(etId)
            id = etId
        }
        return view
    }
}