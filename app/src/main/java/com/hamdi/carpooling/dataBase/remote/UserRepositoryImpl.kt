package com.hamdi.carpooling.dataBase.remote

import android.util.Log
import com.hamdi.carpooling.dataBase.roomDB.AppDatabase
import com.hamdi.carpooling.dataBase.roomDB.User
import com.hamdi.carpooling.dataBase.roomDB.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    //private val dao: UserDao,
    private val db: AppDatabase
) : UserRepository {
    override suspend fun refreshUsers() {
        val usersFromApi = api.getUsers()
        Log.d("HEL:","usersFromApi = $usersFromApi")
        withContext(Dispatchers.IO){
            db.userDao().insertUsers(usersFromApi)
        }
    }

    override suspend fun getUsersFromDb(): List<User> {
        val users = withContext(Dispatchers.IO) {
            db.userDao().getAllUsers()
        }
        Log.d("UserRepository", "Fetched users from DB: $users")
        return users
    }
}