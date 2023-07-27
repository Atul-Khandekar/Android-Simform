package com.example.trainingproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trainingproject.models.CalculatorDataModel

class CalculatorViewModel: ViewModel() {
    val data: MutableLiveData<CalculatorDataModel> = MutableLiveData()
    fun showResult() {
        data.value?.result?.value = ((data.value?.number1?.value?.toInt() ?: 0) * (data.value?.number2?.value?.toInt() ?: 0)).toString()
    }
}