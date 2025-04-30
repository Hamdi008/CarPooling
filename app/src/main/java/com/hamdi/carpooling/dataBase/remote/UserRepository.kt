package com.hamdi.carpooling.dataBase.remote

interface UserRepository {

    suspend fun fetchAndStoreRemoteUsers()
}