package com.example.shopkart.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkart.R
import com.example.shopkart.databinding.SpinnerRowItemBinding
import com.example.trainingproject.models.SpinnerRowItemModel


class SpinnerAdapter(
    private val numbers: ArrayList<SpinnerRowItemModel>,
    var deleteSpinnerCallback: (Int) -> Unit,
) : RecyclerView.Adapter<SpinnerAdapter.ViewHolder>() {

    private lateinit var binding: SpinnerRowItemBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val spinner: Spinner = binding.rowSpinner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SpinnerRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.spinner_row_item, parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d("a", "onbind of spinner adapter of position ${position}")
        val adapter = ArrayAdapter(
            holder.itemView.context,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
            (1..100).toList()
        )
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
        holder.spinner.adapter = adapter

        binding.btnDeleteSpinner.isVisible = itemCount != 1
        binding.btnDeleteSpinner.setOnClickListener {
            deleteSpinnerCallback(position)
        }
    }
}