package com.example.trainingproject.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkart.databinding.CalculatorRowItemBinding
import com.example.trainingproject.models.CalculatorDataModel
import com.example.trainingproject.models.ImageDataModel
import com.example.trainingproject.models.SpinnerRowItemModel


class CalculatorAdapter(private var dataList: ArrayList<CalculatorDataModel>) :
    RecyclerView.Adapter<CalculatorAdapter.ViewHolder>() {
    private lateinit var binding: CalculatorRowItemBinding

    @SuppressLint("NotifyDataSetChanged")
    inner class ViewHolder(private val binding: CalculatorRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onClickAddNumbers() {
            binding.btnAddNumbers.setOnClickListener {

                if (dataList[adapterPosition].spinnerModel.size > 4) {
                    Toast.makeText(
                        itemView.context, "you can add only upto 5 numbers", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    dataList[adapterPosition].spinnerModel.add(SpinnerRowItemModel(5))
                    binding.numbersRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
        }

        init {
            binding.btnAddNumbers.setOnClickListener {
                onClickAddNumbers()
            }

            binding.btnDelete.setOnClickListener {
                dataList.removeAt(adapterPosition)
                notifyDataSetChanged()
            }

            binding.addImage.setOnClickListener {
                dataList[adapterPosition].imageList.add(ImageDataModel(ImageDataModel.getImage()))
                Log.d("p", dataList[adapterPosition].toString())
                notifyDataSetChanged()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            CalculatorRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val calculatorData = dataList[position]

        binding.numbersRecyclerView.adapter = SpinnerAdapter(dataList[position].spinnerModel) {
            dataList[position].spinnerModel.removeAt(it)
            binding.numbersRecyclerView.adapter?.notifyDataSetChanged()
        }

        binding.numbersRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)

        binding.btnDelete.isVisible = itemCount != 1

        val horizontalLayout = LinearLayoutManager(
            holder.itemView.context, LinearLayoutManager.HORIZONTAL, false
        )

        binding.imageRecyclerView.layoutManager = horizontalLayout

        binding.imageRecyclerView.adapter = ImageAdapter(dataList[position].imageList) {
            Log.d("s", dataList[position].imageList.toString())
            dataList[position].imageList.removeAt(it)
            notifyDataSetChanged()
        }

        binding.btnAddNumbers.setOnClickListener {
            holder.onClickAddNumbers()
        }
    }
}