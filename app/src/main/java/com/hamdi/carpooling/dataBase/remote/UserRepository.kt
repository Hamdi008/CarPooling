package com.hamdi.carpooling.dataBase.remote

import com.hamdi.carpooling.dataBase.roomDB.User

interface UserRepository {

    suspend fun fetchRemoteUsers()

//    suspend fun getRoomUsers(): List<User>
}