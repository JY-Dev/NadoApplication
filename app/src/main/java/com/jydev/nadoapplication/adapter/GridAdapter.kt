package com.jydev.nadoapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jydev.nadoapplication.R
import kotlinx.android.synthetic.main.grid_item.view.*
import java.util.zip.Inflater

class GridAdapter(context:Context) : BaseAdapter() {
    private val mContext =context
    private val imgList = mutableListOf(R.drawable.health01,R.drawable.health02,R.drawable.health03,R.drawable.health04)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(mContext).inflate(R.layout.grid_item,null)
        view.grid_img.setBackgroundResource(imgList[position])
        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return 4
    }
}