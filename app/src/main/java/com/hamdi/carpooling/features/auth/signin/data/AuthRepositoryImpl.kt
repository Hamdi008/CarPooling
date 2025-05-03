package com.hamdi.carpooling.features.auth.signin.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest
import com.hamdi.carpooling.features.auth.signin.data.model.LoginResponse
import com.hamdi.carpooling.features.auth.signin.data.model.ProfileResponse
import com.hamdi.carpooling.features.auth.signin.data.remote.AuthApi
import com.hamdi.carpooling.features.auth.signin.domain.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val sharedPreferences: SharedPreferences,
    @ApplicationContext private val context: Context
) : AuthRepository {

    override suspend fun login(request: LoginRequest): Response<LoginResponse> {

        val response = authApi.login(request)
        var jwt = ""

        if (response.isSuccessful) {
            jwt = response.body()?.token ?: ""

            // Store JWT in SharedPreferences
            sharedPreferences.edit() { putString("jwt_token", jwt) }
        }
        return response
    }

    override suspend fun getProfile(): Response<ProfileResponse> {
        val jwt = sharedPreferences.getString("jwt_token", null)

        return if (jwt != null) {
            authApi.getProfile("Bearer $jwt")
        } else {
            Response.error(
                401,
                okhttp3.ResponseBody.create(
                    okhttp3.MediaType.parse("application/json"),
                    "{\"message\":\"JWT missing\"}"
                )
            )
        }
    }

}