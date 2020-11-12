package com.jydev.nadoapplication.activity

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.GridView


class ExpandableHeightGridView : GridView{
    private var mExpanded = false
    constructor(context: Context) : super(context){

    }
    constructor(context: Context, attrs: AttributeSet?) :super(context,attrs){

    }

    constructor(context: Context, attrs: AttributeSet?,defStyle : Int) :super(context,attrs,defStyle){

    }



    fun isExpanded(): Boolean {
        return mExpanded
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // HACK! TAKE THAT ANDROID!
        if (isExpanded()) {
            // Calculate entire height by providing a very large height hint.
            // View.MEASURED_SIZE_MASK represents the largest height possible.
            val expandSpec = MeasureSpec.makeMeasureSpec(
                View.MEASURED_SIZE_MASK,
                MeasureSpec.AT_MOST
            )
            super.onMeasure(widthMeasureSpec, expandSpec)
            val params = layoutParams
            params.height = measuredHeight
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    fun setExpanded(expanded : Boolean) {
        mExpanded = expanded
    }
}