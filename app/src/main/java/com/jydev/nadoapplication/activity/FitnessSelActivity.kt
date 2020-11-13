package com.jydev.nadoapplication.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.adapter.FitenessSelAdapter
import com.jydev.nadoapplication.adapter.FitnessItemAdapter
import com.jydev.nadoapplication.callback.FItCheckCallback
import com.jydev.nadoapplication.callback.FitCallback
import kotlinx.android.synthetic.main.activity_fitness_sel.*
import kotlinx.android.synthetic.main.app_sub_toolbar.*

class FitnessSelActivity : AppCompatActivity() {
    private lateinit var fitnessAdapter : FitnessItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_sel)
        val mLayoutManager = LinearLayoutManager(this@FitnessSelActivity)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        fitnessAdapter = FitnessItemAdapter(this,object : FItCheckCallback{
            override fun onCheck(currentCheck: Int) {
                item_list.post{
                    fitnessAdapter.setCheck(currentCheck)
                    finish_btn.isEnabled = fitnessAdapter.getButtonEnable()
                }
            }
        })
        title_list.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = FitenessSelAdapter(this@FitnessSelActivity,object : FitCallback{
                override fun onItemClick(position: Int , title:String) {
                    if(position>0){
                        mLayoutManager.scrollToPositionWithOffset(position,0)
                        fitnessAdapter.setTitle(title)
                        fitnessAdapter.setCheck(-1)
                        finish_btn.isEnabled = false
                    }
                }
            })
        }
        val mLayoutManager02 = LinearLayoutManager(this@FitnessSelActivity)
        mLayoutManager02.orientation = LinearLayoutManager.VERTICAL
        item_list.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager02
            adapter = fitnessAdapter
        }

        finish_btn.setOnClickListener {
            val intent = Intent()
            setResult(5000,intent)
            finish()
        }
        back_btn.setOnClickListener {
            val intent = Intent()
            setResult(2000,intent)
            finish()
        }
    }

}