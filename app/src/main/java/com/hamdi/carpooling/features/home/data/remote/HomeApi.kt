package com.hamdi.carpooling.features.home.data.remote

import com.hamdi.carpooling.features.home.data.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {

    @GET("home")
    suspend fun getHomeMessage(): Response<HomeResponse>
}