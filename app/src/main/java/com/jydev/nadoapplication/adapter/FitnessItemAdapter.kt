package com.jydev.nadoapplication.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.callback.FItCheckCallback
import kotlinx.android.synthetic.main.fitness_item.view.*

class FitnessItemAdapter(context:Context, checkCallback: FItCheckCallback)  : RecyclerView.Adapter<FitnessItemAdapter.ViewHolder>(){
    class ViewHolder(val mainView: View) : RecyclerView.ViewHolder(mainView)
    private val callback = checkCallback
    private var currentCheck = -1
    private var mTitle = "전체"
    private val mockData = mutableListOf(Pair("스포짐 사당역점","서울시 동작구 동작대로 22-2번지 사당빌딩 3층"), Pair("바디 피트니스센터","서울시 동작구 사당대로 11-27번지 바디빌딩 5층"))
    private val mContext = context
    private val mockImgData = mutableListOf(R.drawable.health02,R.drawable.health03)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.fitness_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(mTitle!="전체") mockData.filter { it.second.split(" ")[0].contains(mTitle) }.size else mockData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mainView.title_tv.text = mockData[position%2].first
        holder.mainView.add_tv.text = mockData[position%2].second
        holder.mainView.img_view.setImageResource(mockImgData[position%2])
        holder.mainView.sel_checkbox.apply {
            isChecked = currentCheck == position
            setOnCheckedChangeListener { _, bool ->
                if(bool||position==currentCheck) callback.onCheck(position)
            }
        }
    }

    fun setTitle(title:String){
        mTitle = title
        notifyDataSetChanged()
    }

    fun setCheck(position: Int){
        currentCheck = if(currentCheck == position) -1 else { position }
        notifyDataSetChanged()
    }

    fun getButtonEnable() = currentCheck!=-1
}