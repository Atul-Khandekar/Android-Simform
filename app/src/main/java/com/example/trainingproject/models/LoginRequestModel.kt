package com.example.trainingproject.models
import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: Int
)