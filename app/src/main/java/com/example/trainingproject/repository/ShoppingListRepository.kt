package com.example.trainingproject.repository

import com.example.trainingproject.apiservices.ShoppingListService

class ShoppingListRepository constructor(private val shoppingListService: ShoppingListService) {
    suspend fun getShoppingList() = shoppingListService.getShoppingList()
}