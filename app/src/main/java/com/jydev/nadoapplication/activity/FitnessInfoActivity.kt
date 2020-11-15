package com.jydev.nadoapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.adapter.InfoPagerAdapter
import kotlinx.android.synthetic.main.activity_fitness_info.*
import java.lang.Math.abs

class FitnessInfoActivity : AppCompatActivity() ,AppBarLayout.OnOffsetChangedListener{
    var test = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_info)
        pager.adapter = InfoPagerAdapter(this)
        indicator.apply {
            setViewPager(pager)
            createIndicators(3,0)
        }
        appbar.addOnOffsetChangedListener(this)
        rd_fitness_info.setOnCheckedChangeListener { _, id ->
                when(id){
                    R.id.center_info -> {

                    }
                    R.id.pt_tutor -> {

                    }
                    R.id.coupon -> {

                    }
                    R.id.noti -> {

                    }
                }
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        val test = appBarLayout?.height?:0
        val height = test-app_toolbar.height
        app_toolbar.alpha = abs(verticalOffset).toFloat()/height
        back_btn02.alpha = 1 - abs(verticalOffset).toFloat()/height
    }
}