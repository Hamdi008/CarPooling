package com.hamdi.carpooling.features.auth.signup.data.remote

import com.hamdi.carpooling.features.auth.signup.data.model.RegisterRequest
import com.hamdi.carpooling.features.auth.signup.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {

    @POST("api/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
}