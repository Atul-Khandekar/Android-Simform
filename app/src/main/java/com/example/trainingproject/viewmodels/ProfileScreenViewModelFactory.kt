package com.example.trainingproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trainingproject.repository.ProfileScreenRepository

class ProfileScreenViewModelFactory constructor(private val repository: ProfileScreenRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProfileScreenViewModel::class.java)) {
            ProfileScreenViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}