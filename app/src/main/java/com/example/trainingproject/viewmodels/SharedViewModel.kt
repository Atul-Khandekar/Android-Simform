package com.example.trainingproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    val messageMutableLiveData = MutableLiveData<String>()

    fun sendMessage(text: String) {
        messageMutableLiveData.value = text
    }
}