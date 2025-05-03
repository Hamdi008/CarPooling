package com.hamdi.carpooling.features.welcome.data

import com.hamdi.carpooling.features.welcome.data.remote.WelcomeApi
import com.hamdi.carpooling.features.welcome.domain.WelcomeRepository
import javax.inject.Inject

class WelcomeRepositoryImpl @Inject constructor(
    private val homeApi: WelcomeApi
) : WelcomeRepository {

    override suspend fun getWelcomeData(): String {

        return try {
            val response = homeApi.getWelcomeData()
            if (response.isSuccessful) {
                response.body()?.welcomeMessage ?: "No message"
            } else {
                "Error: ${response.code()}"
            }
        } catch (e: Exception) {
            "Exception: ${e.message}"
        }
    }
}
