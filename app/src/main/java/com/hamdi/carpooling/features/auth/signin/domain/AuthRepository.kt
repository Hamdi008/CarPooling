package com.hamdi.carpooling.features.auth.signin.domain

import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest
import com.hamdi.carpooling.features.auth.signin.data.model.LoginResponse
import com.hamdi.carpooling.features.auth.signin.data.model.ProfileResponse
import retrofit2.Response

interface AuthRepository {

    suspend fun login(request: LoginRequest): Response<LoginResponse>

    suspend fun getProfile(): Response<ProfileResponse>
}