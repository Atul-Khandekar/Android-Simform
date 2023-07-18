package com.example.trainingproject.apiservices

import com.example.trainingproject.models.AuthenticationResponseModel
import com.example.trainingproject.models.LoginRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/api/authaccount/login")
    suspend fun loginApi(@Body loginRequestModel: LoginRequestModel): Response<AuthenticationResponseModel>
}