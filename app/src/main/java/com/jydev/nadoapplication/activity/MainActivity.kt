package com.jydev.nadoapplication.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.callback.ClearFragmentCallback
import com.jydev.nadoapplication.data.*
import com.jydev.nadoapplication.fragment.ChatFragment
import com.jydev.nadoapplication.fragment.main.*
import com.jydev.nadoapplication.util.FirstCheck.firstCheck
import com.jydev.nadoapplication.util.MenuItem
import com.jydev.nadoapplication.util.ViewModelCase
import com.jydev.nadoapplication.viewmodel.BodyDataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_main_toolbar.*


class MainActivity : AppCompatActivity() {
    private var fragmentList = mutableListOf<Fragment>()
    private val fragmentManager: FragmentManager = supportFragmentManager
    private lateinit var firstFragment: Fragment
    private var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
    private var mainFlag = true
    private var preMenuId = 0
    private val mockHeight = 173F
    private val age = 28F
    private val mockInBodyData = InBodyData(70.2F, 13.5F, 22.5F, 57.5F, 8.5F, 3.2F)
    private val mockFatData = FatData(22.5F, 13.5F, 0.83F, 1725F)
    private val mockMuscleFatControllData = MuscleFatControll(-3.7F, 8.1F, -4.4F)
    private val mockHrBp = HrBp(62F, 112F, 79F)
    private val model: BodyDataViewModel by viewModels()
    private var backPressTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model.setBody(
            Body(
                age,
                mockHeight,
                mockInBodyData,
                mockFatData,
                mockMuscleFatControllData,
                mockHrBp
            )
        )
        ViewModelCase.model = model
        layoutInit()
    }

    private fun layoutInit() {
        firstFragment =
            if (firstCheck) StartFragment() else MainFragment01(object : ClearFragmentCallback {
                override fun clearFragment() {
                    firstCheck = true
                    mainFlag = !mainFlag
                    layoutInit()
                }
            })
        fragmentList = mutableListOf(
            firstFragment,
            MainFragment02(),
            ReportFragment(),
            MyPageFragment(),
            ChatFragment(),
            SearchFragment()
        )
        setFragment(MenuItem.MAIN01.ordinal)
        preMenuId = R.id.home
        bottom_navigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.home -> {
                    if (preMenuId == item.itemId) setAnimation()
                    toolbar_title.text = "헬스케어링"
                    if (!firstCheck) setFragment(if (mainFlag) MenuItem.MAIN01.ordinal else MenuItem.MAIN02.ordinal)
                    else setFragment(MenuItem.MAIN01.ordinal)
                }
                R.id.search ->{
                    toolbar_title.text = "검색"
                    setFragment(MenuItem.SEARCH.ordinal)
                }
                R.id.chat -> {
                    toolbar_title.text = "채팅"
                    setFragment(MenuItem.CHAT.ordinal)
                }
                R.id.report -> {
                    toolbar_title.text = "건강관리"
                    setFragment(MenuItem.REPORT.ordinal)
                }
                R.id.mypage -> {
                    toolbar_title.text = "마이페이지"

                    setFragment(MenuItem.MYPAGE.ordinal)
                }
            }
            preMenuId = item.itemId
            true
        }
    }

    private fun setFragment(position: Int) {
        if (!firstCheck) mainFlag = !mainFlag
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentList[position])
            .commitAllowingStateLoss()
    }

    private fun setAnimation() {
        YoYo.with(Techniques.Wobble)
            .duration(1000)
            .playOn(main_view)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 5000) {
            firstCheck = false
            layoutInit()
        }
    }

    override fun onBackPressed() {
        if(backPressTime==0L||backPressTime+1000L<System.currentTimeMillis()){
            backPressTime = System.currentTimeMillis()
            Toast.makeText(this,"한번더 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show()
        }
        else finish()
    }


}
