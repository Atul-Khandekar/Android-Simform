package com.example.trainingproject.apiservices

import com.example.trainingproject.models.AuthenticationResponseModel
import com.example.trainingproject.models.RegisterRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("/api/authaccount/registration")
    suspend fun registerUser(@Body registerRequestModel: RegisterRequestModel) : Response<AuthenticationResponseModel>
}