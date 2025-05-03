package com.hamdi.carpooling.features.auth.logout.domain

import com.hamdi.carpooling.features.auth.logout.data.model.LogoutResponse
import retrofit2.Response

interface LogoutRepository {

    suspend fun logoutUser(): Response<LogoutResponse>
}