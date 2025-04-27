package com.hamdi.carpooling.dataBase.remote

import com.hamdi.carpooling.dataBase.roomDB.User

interface UserRepository {

    suspend fun refreshUsers()

    suspend fun getUsersFromDb(): List<User>
}