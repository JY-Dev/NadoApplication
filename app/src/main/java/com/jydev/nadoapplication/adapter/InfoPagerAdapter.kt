package com.jydev.nadoapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jydev.nadoapplication.fragment.InfoImgFragment
import com.jydev.nadoapplication.fragment.guide.GuideFragment

class InfoPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> InfoImgFragment(position)
            1 -> InfoImgFragment(position)
            2 -> InfoImgFragment(position)
            else -> InfoImgFragment(0)
        }
    }
}