package com.hamdi.carpooling.features.auth.logout.data

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.hamdi.carpooling.features.auth.logout.data.model.LogoutResponse
import com.hamdi.carpooling.features.auth.logout.data.remote.LogoutApi
import com.hamdi.carpooling.features.auth.logout.domain.LogoutRepository
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class LogoutRepositoryImpl @Inject constructor(
    private val logoutApi: LogoutApi,
    private val sharedPreferences: SharedPreferences,
) : LogoutRepository {
    override suspend fun logoutUser(): Response<LogoutResponse> {
        val jwt = sharedPreferences.getString("jwt_token", null)

        val response: Response<LogoutResponse>

        if (jwt == null) {
            response = Response.error(401, ResponseBody.create(null, "Unauthorized: No JWT token"))
        } else {
            // Proceed with the logout process if JWT exists
            response = try {
                val apiResponse = logoutApi.logout("Bearer $jwt")

                if (apiResponse.isSuccessful) {
                    sharedPreferences.edit{ remove("jwt_token") }
                    Log.d("Logout", "Success: ${apiResponse.body()?.message}")
                } else {
                    Log.e("Logout", "Failed: ${apiResponse.code()}")
                }

                apiResponse
            } catch (e: Exception) {
                Log.e("Logout", "Error: ${e.message}")
                Response.error(500, ResponseBody.create(null, "Internal Server Error"))
            }
        }

        return response
    }
}