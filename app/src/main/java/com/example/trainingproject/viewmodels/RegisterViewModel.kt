package com.example.trainingproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.models.AuthenticationResponseModel
import com.example.trainingproject.models.RegisterRequestModel
import com.example.trainingproject.repository.RegisterUserRepository
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.schedule

class RegisterViewModel(private val registerUserRepository: RegisterUserRepository) : ViewModel() {

    val registerResult: MutableLiveData<BaseResponse<AuthenticationResponseModel>> =
        MutableLiveData()

    fun registerUser(email: String, name: String, password: Int) {

        registerResult.postValue(BaseResponse.Loading())
        Timer().schedule(2000) {
            viewModelScope.launch {
                val registerDetails = RegisterRequestModel(email, name, password)
                val response = registerUserRepository.callRegisterApi(registerDetails)
                try {
                    if (response.code() in 200..299) {
                        registerResult.postValue(BaseResponse.Success(response.body()))
                    } else {
                        registerResult.postValue(BaseResponse.Error("Invalid Email or Password"))
                    }
                } catch (e: Exception) {
                    registerResult.postValue(BaseResponse.Error(e.message))
                }
            }
        }
    }
}