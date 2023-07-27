package com.example.trainingproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.models.ProfileResponseModel
import com.example.trainingproject.repository.ProfileScreenRepository
import kotlinx.coroutines.launch

class ProfileScreenViewModel(private val profileScreenRepository: ProfileScreenRepository): ViewModel() {

    val profileResult: MutableLiveData<BaseResponse<ProfileResponseModel>> = MutableLiveData()
    fun getProfileScreen(id: String) {
        viewModelScope.launch {
            try {
                val response = profileScreenRepository.getProfileScreen(id)
                if (response.code() in 200..299) {
                    profileResult.postValue(BaseResponse.Success(response.body()))
                } else {
                    profileResult.postValue(BaseResponse.Error(response.message()))

                }
            } catch (e: Exception) {
                profileResult.postValue(BaseResponse.Error(e.message))
            }
        }
    }
}