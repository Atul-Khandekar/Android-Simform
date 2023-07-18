package com.example.trainingproject.models


import com.google.gson.annotations.SerializedName

data class ProfileResponseModel(
    @SerializedName("createdat")
    val createdat: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("\$id")
    val id: String,
    @SerializedName("id")
    val profileId: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profilepicture")
    val profilePicture: String
)