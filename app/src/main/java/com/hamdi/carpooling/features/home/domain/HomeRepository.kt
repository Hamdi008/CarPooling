package com.hamdi.carpooling.features.home.domain

interface HomeRepository {
    suspend fun getHomeData(): String
}