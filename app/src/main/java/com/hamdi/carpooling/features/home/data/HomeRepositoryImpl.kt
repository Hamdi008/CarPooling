package com.hamdi.carpooling.features.home.data

import android.util.Log
import com.hamdi.carpooling.features.home.data.remote.HomeApi
import com.hamdi.carpooling.features.home.domain.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi
) : HomeRepository {

    override suspend fun getHomeData(): String {

        Log.d("HEL:","HomeRepositoryImpl getHomeData")
        return try {
            val response = homeApi.getHomeMessage()
            if (response.isSuccessful) {
                response.body()?.homeMessage ?: "No message"
            } else {
                "Error: ${response.code()}"
            }
        } catch (e: Exception) {
            "Exception: ${e.message}"
        }
    }
}
