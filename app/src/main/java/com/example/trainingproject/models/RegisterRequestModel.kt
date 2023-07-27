package com.example.trainingproject.models


import com.google.gson.annotations.SerializedName

data class RegisterRequestModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: Int
)