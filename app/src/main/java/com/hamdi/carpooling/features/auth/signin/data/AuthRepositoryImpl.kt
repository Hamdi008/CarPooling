package com.hamdi.carpooling.features.auth.signin.data

import android.content.Context
import android.util.Log
import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest
import com.hamdi.carpooling.features.auth.signin.data.remote.AuthApi
import com.hamdi.carpooling.features.auth.signin.domain.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import androidx.core.content.edit

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    @ApplicationContext private val context: Context
) : AuthRepository {

    override suspend fun login(request: LoginRequest): String {

        val response = authApi.login(request)
        var jwt = ""

        if (response.isSuccessful) {
            jwt = response.body()?.token ?: ""
            Log.e("HEL:", "jwt: $jwt")

            // Store JWT in SharedPreferences
            val prefs = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
            prefs.edit() { putString("jwt", jwt) }
        } else {
            Log.e("HEL:", "Invalid credentials: ${response.code()}")
        }
        return jwt
    }

    override suspend fun getProfile() {
        val prefs = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
        val jwt = prefs.getString("jwt", null)

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