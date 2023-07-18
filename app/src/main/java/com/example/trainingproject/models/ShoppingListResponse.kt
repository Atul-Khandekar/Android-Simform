package com.example.trainingproject.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ShoppingListResponse : ArrayList<ShoppingListResponse.ShoppingListModelItem>(), Serializable {
    data class ShoppingListModelItem (
        @SerializedName("category")
        val category: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("price")
        val price: Double,
        @SerializedName("rating")
        val rating: Rating,
        @SerializedName("title")
        val title: String,
    ) : Serializable

    data class Rating(
        @SerializedName("count")
        val count: Int,
        @SerializedName("rate")
        val rate: Double,
    ) : Serializable
}