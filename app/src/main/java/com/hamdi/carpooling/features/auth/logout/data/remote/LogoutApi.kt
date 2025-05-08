package com.hamdi.carpooling.features.auth.logout.data.remote

import com.hamdi.carpooling.features.auth.logout.data.model.LogoutResponse
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST

interface LogoutApi {

    @POST("api/logout")
    suspend fun logout(@Header("Authorization") token: String): Response<LogoutResponse>
}