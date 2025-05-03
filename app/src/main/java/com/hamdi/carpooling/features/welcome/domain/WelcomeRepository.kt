package com.hamdi.carpooling.features.welcome.domain

interface WelcomeRepository {
    suspend fun getWelcomeData(): String
}