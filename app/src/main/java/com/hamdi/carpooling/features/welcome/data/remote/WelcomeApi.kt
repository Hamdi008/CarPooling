package com.hamdi.carpooling.features.welcome.data.remote

import com.hamdi.carpooling.features.welcome.data.model.WelcomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface WelcomeApi {

    @GET("api/welcome")
    suspend fun getWelcomeData(): Response<WelcomeResponse>
}