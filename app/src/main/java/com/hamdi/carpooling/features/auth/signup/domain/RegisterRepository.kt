package com.hamdi.carpooling.features.auth.signup.domain

import com.hamdi.carpooling.features.auth.signup.data.model.RegisterRequest
import com.hamdi.carpooling.features.auth.signup.data.model.RegisterResponse
import retrofit2.Response

interface RegisterRepository {

    suspend fun register(request: RegisterRequest): Response<RegisterResponse>
}