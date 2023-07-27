package com.example.trainingproject.repository

import com.example.trainingproject.apiservices.LoginService
import com.example.trainingproject.models.LoginRequestModel

class LoginRepository(private val loginService: LoginService) {

    suspend fun callLoginApi(email: String, password: Int) = loginService.loginApi(
        LoginRequestModel(email, password)
    )
}