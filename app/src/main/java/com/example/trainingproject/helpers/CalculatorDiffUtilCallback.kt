package com.example.trainingproject.helpers

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.trainingproject.models.CalculatorDataModel

class CalculatorDiffUtilCallback(
    private val oldList: List<CalculatorDataModel>,
    private val newList: List<CalculatorDataModel>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d("s", (oldList[oldItemPosition] == newList[newItemPosition]).toString())
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].spinnerModel.toString() == newList[newItemPosition].spinnerModel.toString() -> true
            oldList[oldItemPosition].number1 == newList[newItemPosition].number1 -> true
            oldList[oldItemPosition].number2 == newList[newItemPosition].number2 -> true
            else -> false
        }

    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}