package com.hamdi.carpooling.features.auth.signin.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest
import com.hamdi.carpooling.features.auth.signin.data.remote.AuthApi
import com.hamdi.carpooling.features.auth.signin.domain.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import androidx.core.content.edit
import com.hamdi.carpooling.features.auth.signin.data.model.LoginResponse
import retrofit2.Response

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
            Log.e("HEL:", "jwt: $jwt")

            // Store JWT in SharedPreferences
            sharedPreferences.edit() { putString("jwt_token", "Bearer $jwt") }
        } else {
            Log.e("HEL:", "Invalid credentials: ${response.code()}")
        }
        return response
    }

    override suspend fun getProfile() {
        val jwt = sharedPreferences.getString("jwt_token", null)

        if (jwt != null) {
            val profileResponse = authApi.getProfile("Bearer $jwt")
            if (profileResponse.isSuccessful) {
                val profile = profileResponse.body()
                // Display user info
                Log.e("HEL:", "getProfile: profile = $profile")

            } else {
                Log.e("HEL:", "getProfile: Unauthorized or expired token")
            }
        }

    }
}