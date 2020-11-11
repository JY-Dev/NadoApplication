package com.jydev.nadoapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.adapter.GuidePagerAdapter
import kotlinx.android.synthetic.main.activity_guide.*
import me.relex.circleindicator.CircleIndicator3

class GuideActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        pager.apply {
            adapter = GuidePagerAdapter(this@GuideActivity)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            currentItem = 0
        }
        indicator.apply {
            setViewPager(pager)
            createIndicators(3,0)
        }
        skip_btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}