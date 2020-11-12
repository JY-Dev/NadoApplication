package com.jydev.nadoapplication.fragment.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.fragment_rec_meal.view.*


class PtSubFragment : Fragment() {
    private lateinit var subView : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pt_sub, container, false)
        subView = view.sub_view
        addSubItem()
        return view
    }

    private fun addSubItem(){
        val view = LayoutInflater.from(context).inflate(R.layout.pt_sub_item,null)
        subView.addView(view)
    }


}