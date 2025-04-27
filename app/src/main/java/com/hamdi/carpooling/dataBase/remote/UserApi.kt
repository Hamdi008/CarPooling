package com.hamdi.carpooling.dataBase.remote

import com.hamdi.carpooling.dataBase.roomDB.User
import retrofit2.http.GET

interface UserApi {
    @GET("users") // 🛠️ Adjust endpoint if needed
    suspend fun getUsers(): List<User>
}