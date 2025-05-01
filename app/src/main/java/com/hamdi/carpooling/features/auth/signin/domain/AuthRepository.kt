package com.hamdi.carpooling.features.auth.signin.domain

import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest

interface AuthRepository {

    suspend fun login(request: LoginRequest): String

    suspend fun getProfile()
}