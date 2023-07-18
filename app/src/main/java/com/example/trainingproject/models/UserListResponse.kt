package com.example.trainingproject.models

import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @SerializedName("data") val `data`: List<UserListData>,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("support") val support: Support,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val totalPages: Int,
)

data class UserListData(
    @SerializedName("avatar") val avatar: String,
    @SerializedName("email") val email: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("id") val id: Int,
    @SerializedName("last_name") val lastName: String,
)

data class Support(
    @SerializedName("text") val text: String,
    @SerializedName("url") val url: String,
)