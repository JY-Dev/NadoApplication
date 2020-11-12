package com.jydev.nadoapplication.fragment.guide

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.fragment_guide.view.*

class GuideFragment(position: Int) : Fragment() {
    private val mPosition = position
    private lateinit var titleList: Array<String>
    private lateinit var imgList: TypedArray
    override fun onAttach(context: Context) {
        super.onAttach(context)
        titleList = resources.getStringArray(R.array.guideList)
        imgList = resources.obtainTypedArray(R.array.guideListImg)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_guide, null, false)
        view.test_tv.text = titleList[mPosition]
        view.test_img.setImageDrawable(imgList.getDrawable(mPosition))
        return view
    }
}