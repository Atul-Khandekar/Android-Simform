package com.example.trainingproject.models

import com.google.gson.annotations.SerializedName

data class AuthenticationResponseModel(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val `data`: Data?,
    @SerializedName("message") val message: String?,
    @SerializedName("Message") val badRequestMessage: String?,
    @SerializedName("ModelState") val modelState: InvalidState?,
)

data class Data(
    @SerializedName("Email") val email: String?,
    @SerializedName("Id") val id: Int?,
    @SerializedName("Name") val name: String?,
    @SerializedName("Token") val token: String?,
)

data class InvalidState(
    @SerializedName("User.email") val invalidEmailMessage: Array<Any>?,
    @SerializedName("User.password") val invalidPasswordMessage: Array<Any>?,
)