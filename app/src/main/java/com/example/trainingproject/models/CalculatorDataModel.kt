package com.example.trainingproject.models

import androidx.lifecycle.MutableLiveData

data class CalculatorDataModel(
    val id: Long,
    var number1: MutableLiveData<String>,
    var number2: MutableLiveData<String>,
    var spinnerModel: ArrayList<SpinnerRowItemModel>,
    var result: MutableLiveData<String>,
    var imageList: ArrayList<ImageDataModel>,
) {

    val compute by lazy {
        result.value = ((number1.value?.toInt() ?: 0) * (number2.value?.toInt() ?: 0)).toString()
    }

    companion object {
        fun getData(): ArrayList<CalculatorDataModel> {
            var data = arrayListOf<CalculatorDataModel>(
                CalculatorDataModel(
                    1,
                    MutableLiveData("23"),
                    MutableLiveData("0"),
                    arrayListOf(SpinnerRowItemModel(2)),
                    MutableLiveData("0"),
                    arrayListOf(
                        ImageDataModel(ImageDataModel.getImage())
                    )
                )
            )
            return data
        }
    }
}