package com.example.trainingproject.repository

import com.example.trainingproject.apiservices.RegisterService
import com.example.trainingproject.models.RegisterRequestModel

class RegisterUserRepository(private val registerService: RegisterService) {

    suspend fun callRegisterApi(registerRequestModel: RegisterRequestModel) = registerService.registerUser(registerRequestModel)
}