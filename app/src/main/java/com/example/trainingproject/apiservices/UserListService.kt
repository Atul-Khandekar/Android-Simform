package com.example.trainingproject.apiservices

import com.example.trainingproject.models.UserListResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserListService {
    @GET("/api/users?page=1")
    suspend fun getUserList(): Response<UserListResponse>
}