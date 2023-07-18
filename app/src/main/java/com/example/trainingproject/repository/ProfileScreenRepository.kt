package com.example.trainingproject.repository

import com.example.trainingproject.apiservices.ProfileScreenService

class ProfileScreenRepository(private val profileScreenService: ProfileScreenService) {
    suspend fun getProfileScreen(id: String) = profileScreenService.getUserProfile(id)
}