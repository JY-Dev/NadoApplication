package com.jydev.nadoapplication.fragment.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.fragment_rec_exer.view.*

class RecExerFragment : Fragment() {
    private val mockData = mutableListOf("스쿼드 3set(20회 X 3번)","런닝머신 30분(속도 4~6)","윗몸일으키기 3set(30회 X 3번)","팔굽혀펴기 5set(20회 X 5번)","런치3set(15회 X 3번)","복근운동 5set(20회 X 5번)")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rec_exer, container, false)
        var data = ""
        mockData.forEach {
            data+=it+"\n"
        }
        view.weekday_data_tv.text = data
        return view
    }

}