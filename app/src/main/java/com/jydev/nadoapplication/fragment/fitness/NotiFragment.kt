package com.jydev.nadoapplication.fragment.fitness

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.adapter.NotiAdapter
import kotlinx.android.synthetic.main.fragment_noti.view.*
import kotlinx.android.synthetic.main.fragment_noti.view.list_view
import kotlinx.android.synthetic.main.fragment_pttutor.view.*

class NotiFragment : Fragment() {
    private lateinit var mContext : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_noti, container, false)
        val adapter = NotiAdapter(mContext)
        view.list_view.adapter = adapter
        view.list_view.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(mContext,"서비스 준비중입니다.", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}