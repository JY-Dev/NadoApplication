package com.jydev.nadoapplication.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.callback.ClearFragmentCallback
import kotlinx.android.synthetic.main.fragment_main01.view.*

class MainFragment01(clearFragmentCallback: ClearFragmentCallback) : Fragment() {
    private val callback = clearFragmentCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main01, container, false)
        view.pre_btn.setOnClickListener {
            callback.clearFragment()
        }
        return view
    }

}