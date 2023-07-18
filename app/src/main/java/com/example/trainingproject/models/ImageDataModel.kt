package com.example.trainingproject.models

import com.example.shopkart.R

data class ImageDataModel(val Image: Int) {

    companion object {
        val images = arrayListOf(
            R.drawable.ic_human_chilling,
            R.drawable.ic_human_cycle,
            R.drawable.ic_human_scientist,
            R.drawable.ic_human_skating,
            R.drawable.ic_human_working,
            R.drawable.ic_man_with_phone,
            R.drawable.ic_woman_working,
            R.drawable.ic_women_cycling,
            R.drawable.ic_women_with_phone
        )
        fun getImage(): Int {
            return images.random()
        }
    }
}