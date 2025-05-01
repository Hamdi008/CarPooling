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
        val response = registerApi.register(request)

        if (response.isSuccessful) {
            val result = response.body()
            Log.d("HEL:",  " RegisterSuccess: ${result?.message}")
        } else {
            Log.e("HEL:", "Register Failed: ${response.code()} - ${response.errorBody()?.string()}")
        }
        return response
    }
}