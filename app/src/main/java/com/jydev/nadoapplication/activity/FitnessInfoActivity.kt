package com.jydev.nadoapplication.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.appbar.AppBarLayout
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.adapter.InfoPagerAdapter
import com.jydev.nadoapplication.fragment.fitness.CenterInfoFragment
import com.jydev.nadoapplication.fragment.fitness.CouponFragment
import com.jydev.nadoapplication.fragment.fitness.NotiFragment
import com.jydev.nadoapplication.fragment.fitness.PttutorFragment
import com.jydev.nadoapplication.util.MenuItem
import kotlinx.android.synthetic.main.activity_fitness_info.*
import java.lang.Math.abs

class FitnessInfoActivity : AppCompatActivity() ,AppBarLayout.OnOffsetChangedListener{
    lateinit var fragmentTransaction: FragmentTransaction
    private var fragmentList = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInit()
    }

    private fun layoutInit(){
        setContentView(R.layout.activity_fitness_info)
        supportActionBar?.setDisplayShowTitleEnabled(false);
        fragmentList.addAll(mutableListOf(CenterInfoFragment(),PttutorFragment(),CouponFragment(),NotiFragment()))
        setFragment(0)
        pager.adapter = InfoPagerAdapter(this)

        indicator.apply {
            setViewPager(pager)
            createIndicators(3,0)
        }
        appbar.addOnOffsetChangedListener(this)

        rd_fitness_info.setOnCheckedChangeListener { _, id ->
            setFragment(rd_fitness_info.indexOfChild(findViewById(id)))
        }
        back_btn.setOnClickListener(onClickListner)
        back_btn02.setOnClickListener(onClickListner)


    }

    private val onClickListner = View.OnClickListener { finish() }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        val test = appBarLayout?.height?:0
        val height = test-app_toolbar.height
        app_toolbar.alpha = abs(verticalOffset).toFloat()/height
        back_btn02.alpha = 1 - abs(verticalOffset).toFloat()/height
    }

    private fun setFragment(position: Int) {
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentList[position])
            .commitAllowingStateLoss()
    }
}