package com.hamdi.carpooling.dataBase.remote

import com.hamdi.carpooling.dataBase.roomDB.User
import com.hamdi.carpooling.dataBase.roomDB.UserDao
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val dao: UserDao
) : UserRepository {
    override suspend fun refreshUsers() {
        val usersFromApi = api.getUsers()
        dao.insertUsers(usersFromApi)
    }

    override suspend fun getUsersFromDb(): List<User> = dao.getAllUsers()
}