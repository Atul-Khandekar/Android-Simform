package com.example.trainingproject.apiservices

import com.example.trainingproject.models.ShoppingListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ShoppingListService {
    @GET("/products")
    suspend fun getShoppingList(): Response<ShoppingListResponse>
}