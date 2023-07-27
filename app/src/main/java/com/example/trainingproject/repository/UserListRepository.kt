package com.example.trainingproject.repository

import com.example.trainingproject.apiservices.UserListService

class UserListRepository(private val userListService: UserListService) {

    suspend fun getUserList() = userListService.getUserList()

}