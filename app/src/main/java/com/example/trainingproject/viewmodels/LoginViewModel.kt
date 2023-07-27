package com.example.trainingproject.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.helpers.Connectivity
import com.example.trainingproject.models.AuthenticationResponseModel
import com.example.trainingproject.repository.LoginRepository
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.schedule

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    val _hasInternetConnection = MutableLiveData<Boolean>()
    val loginResult: MutableLiveData<BaseResponse<AuthenticationResponseModel>> = MutableLiveData()
    fun callLoginApi(email: String, password: Int) {
        loginResult.postValue(BaseResponse.Loading())
        Timer().schedule(2000) {
            viewModelScope.launch {
                try {
                    val response = loginRepository.callLoginApi(email, password)
                    if (response.code() in 200..299) {
                        loginResult.postValue(BaseResponse.Success(response.body()))
                    } else {
                        loginResult.postValue(BaseResponse.Error(response.message()))

                    }
                } catch (e: Exception) {
                    loginResult.postValue(BaseResponse.Error(e.message))
                }
            }
        }
    }

    fun hasInternetConnection(context: Context) {
        viewModelScope.launch {
            _hasInternetConnection.postValue(Connectivity.hasInternetConnected(context))
        }
    }
}