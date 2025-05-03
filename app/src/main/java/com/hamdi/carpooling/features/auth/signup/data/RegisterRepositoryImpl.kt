package com.hamdi.carpooling.features.auth.signup.data

import android.util.Log
import com.hamdi.carpooling.features.auth.signup.data.model.RegisterRequest
import com.hamdi.carpooling.features.auth.signup.data.model.RegisterResponse
import com.hamdi.carpooling.features.auth.signup.data.remote.RegisterApi
import com.hamdi.carpooling.features.auth.signup.domain.RegisterRepository
import retrofit2.Response
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(
    private val registerApi: RegisterApi
): RegisterRepository {

    override suspend fun register(request: RegisterRequest): Response<RegisterResponse> {
        return registerApi.register(request)
    }
}