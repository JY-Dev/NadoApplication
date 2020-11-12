package com.jydev.nadoapplication.fragment.main

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.fragment.report.PtSubFragment
import com.jydev.nadoapplication.fragment.report.RecExerFragment
import com.jydev.nadoapplication.fragment.report.RecMealFragment
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.android.synthetic.main.fragment_report.view.*


class ReportFragment : Fragment() {
    lateinit var fragmentTransaction: FragmentTransaction
    private var fragmentList = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentList = mutableListOf(RecMealFragment(),
            RecExerFragment(),
            PtSubFragment()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_report, container, false)
        fragmentTransaction = childFragmentManager.beginTransaction()
        view.rd_report.setOnCheckedChangeListener { _, i ->
            when(i){
                R.id.rec_meal-> setFragment(0)
                R.id.rec_exercise -> setFragment(1)
                R.id.pt_sub -> setFragment(2)
            }
        }
        view.rec_meal.isChecked = true
        return view
    }

    private fun setFragment(position: Int) {
        fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentList[position])
            .commitAllowingStateLoss()
    }



}