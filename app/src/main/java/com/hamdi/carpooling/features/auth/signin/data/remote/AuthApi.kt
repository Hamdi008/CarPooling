package com.hamdi.carpooling.features.auth.signin.data.remote

import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest
import com.hamdi.carpooling.features.auth.signin.data.model.LoginResponse
import com.hamdi.carpooling.features.auth.signin.data.model.ProfileResponse
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("profile")
    suspend fun getProfile(@Header("Authorization") token: String): Response<ProfileResponse>
}