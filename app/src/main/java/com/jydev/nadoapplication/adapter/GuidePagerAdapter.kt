package com.jydev.nadoapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jydev.nadoapplication.fragment.guide.GuideFragment

class GuidePagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> GuideFragment(position)
            1 -> GuideFragment(position)
            2 -> GuideFragment(position)
            else -> GuideFragment(0)
        }
    }
}