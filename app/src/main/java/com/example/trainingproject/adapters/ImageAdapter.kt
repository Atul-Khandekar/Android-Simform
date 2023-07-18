package com.example.trainingproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkart.databinding.ImageRowItemBinding
import com.example.trainingproject.models.ImageDataModel

class ImageAdapter(
    private val imageList: ArrayList<ImageDataModel>,
    val onDeleteImage: (Int) -> Unit,
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private lateinit var binding: ImageRowItemBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ImageRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, imagePosition: Int) {
        binding.image.setImageResource(imageList[imagePosition].Image)
        binding.btnDeleteImage.setOnClickListener {
            onDeleteImage(imagePosition)
        }

        binding.btnDeleteImage.isVisible = itemCount != 1

    }

}