package com.jydev.nadoapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.callback.FitCallback
import kotlinx.android.synthetic.main.fitness_sel_item.view.*

class FitenessSelAdapter(context: Context ,onItemClick : FitCallback) : RecyclerView.Adapter<FitenessSelAdapter.ViewHolder>() {
    val mockData = mutableListOf("","전체","서울", "부산", "경기도", "인천", "대전", "대구", "광주")
    private var checkPosition = 1
    private val mOnItemClick = onItemClick

    class ViewHolder(val mainView: View) : RecyclerView.ViewHolder(mainView)

    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(mContext).inflate(R.layout.fitness_sel_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mockData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.mainView.findViewById<TextView>(R.id.title_tv)
        val wholeView = holder.mainView.findViewById<LinearLayout>(R.id.whole_view)
        val imgView = holder.mainView.findViewById<ImageView>(R.id.img_view)
        wholeView.setOnClickListener {
            setCheck(position)
            mOnItemClick.onItemClick(position,mockData[position])
        }
        if (position == checkPosition) textView.setTextColor(
            mContext.resources.getColor(
                R.color.text_color,
                null
            )
        )
        else textView.setTextColor(mContext.resources.getColor(R.color.disable_text_color, null))
        if(position!=0){
            textView.visibility = View.VISIBLE
            imgView.setImageResource(0)
            textView.text = mockData[position]
        }
        else {
            textView.visibility = View.GONE
            imgView.setImageResource(R.drawable.search)
        }
    }

    private fun setCheck(position: Int) {
        if (position != 0) {
            checkPosition = position
            notifyDataSetChanged()
        }
    }
}