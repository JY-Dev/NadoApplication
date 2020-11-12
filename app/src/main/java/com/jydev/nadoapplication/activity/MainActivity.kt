package com.jydev.nadoapplication.activity

import android.os.Bundle
import android.transition.Slide
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.fragment.MainFragment01
import com.jydev.nadoapplication.fragment.MainFragment02
import com.jydev.nadoapplication.fragment.ReportFragment
import com.jydev.nadoapplication.util.MenuItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var fragmentList = mutableListOf<Fragment>()
    private val fragmentManager: FragmentManager = supportFragmentManager
    private var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
    private var mainFlag = true
    private var preMenuId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutInit()
    }

    private fun layoutInit() {
        fragmentList = mutableListOf(MainFragment01(), MainFragment02(), ReportFragment())
        setFragment(MenuItem.MAIN01.ordinal)
        preMenuId = R.id.home
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    if (preMenuId == item.itemId) setAnimation()
                    setFragment(if (mainFlag) MenuItem.MAIN01.ordinal else MenuItem.MAIN02.ordinal)
                }
                R.id.report ->
                    setFragment(MenuItem.REPORT.ordinal)
            }
            preMenuId = item.itemId
            true
        }
    }

    private fun setFragment(position: Int) {
        mainFlag = !mainFlag
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentList[position])
            .commitAllowingStateLoss()
    }

    private fun setAnimation() {
        YoYo.with(Techniques.Wobble)
            .duration(1000)
            .playOn(main_view)
    }


}
