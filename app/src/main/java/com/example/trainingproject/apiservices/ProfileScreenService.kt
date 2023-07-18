package com.example.trainingproject.apiservices

import com.example.trainingproject.models.ProfileResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileScreenService {
    @GET("/api/users/{Id}")
    suspend fun getUserProfile(@Path ("Id") id: String): Response<ProfileResponseModel>
}