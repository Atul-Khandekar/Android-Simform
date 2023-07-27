package com.example.trainingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.shopkart.R
import com.google.android.material.tabs.TabLayout

class GeminiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gemini)
        val tablayOut = findViewById<TabLayout>(R.id.tabBar)
        tablayOut.addTab(tablayOut.newTab().setText(R.string.limit))
        tablayOut.addTab(tablayOut.newTab().setText(R.string.market))
        tablayOut.addTab(tablayOut.newTab().setText(R.string.pool))
        tablayOut.addTab(tablayOut.newTab().setText(R.string.info))
        tablayOut.tabGravity = TabLayout.GRAVITY_START
        var tab = tablayOut.getTabAt(tablayOut.selectedTabPosition)

        var txtView = findViewById<TextView>(R.id.txtExchange)
        tablayOut.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> txtView.setText(R.string.limit)
                    1 -> txtView.setText(R.string.market)
                    2 -> txtView.setText(R.string.pool)
                    3 -> txtView.setText(R.string.info)
                    else -> {}
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}