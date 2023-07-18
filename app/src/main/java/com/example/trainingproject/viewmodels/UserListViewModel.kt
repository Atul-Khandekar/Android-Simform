package com.example.trainingproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.models.UserListResponse
import com.example.trainingproject.repository.UserListRepository
import kotlinx.coroutines.launch

class UserListViewModel(private val repository: UserListRepository): ViewModel() {

    var mutableUserList = MutableLiveData<UserListResponse>()
    fun getUserList() {
        viewModelScope.launch {
            mutableUserList.value = repository.getUserList().body()
        }
    }
}