package com.hamdi.carpooling.dataBase.remote

import android.util.Log
import com.hamdi.carpooling.dataBase.roomDB.AppDatabase
import com.hamdi.carpooling.dataBase.roomDB.RoomUserRepository
import com.hamdi.carpooling.dataBase.roomDB.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val db: AppDatabase
) : UserRepository, RoomUserRepository {

    override suspend fun fetchAndStoreRemoteUsers() {
        val usersFromApi = api.getUsers()
        withContext(Dispatchers.IO){
            db.userDao().insertRoomUsers(usersFromApi)
        }
    }

    override suspend fun insertRoomUser(user: User) {
        withContext(Dispatchers.IO) {
            db.userDao().insertRoomUser(user)
        }
    }

    override suspend fun insertRoomUser(username: String, email: String, password: String) {
        withContext(Dispatchers.IO) {
            db.userDao().insertRoomUser(username, email, password)
        }
    }

    override suspend fun insertRoomUsers(users: List<User>) {
        withContext(Dispatchers.IO) {
            db.userDao().insertRoomUsers(users)
        }
    }

    override suspend fun getRoomUser(username: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUser(username, password)
        }
    }

    override suspend fun getAllRoomUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getAllRoomUsers()
        }
    }

    override suspend fun getRoomUserById(id: Int): User? {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUserById(id)
        }
    }

    override suspend fun getRoomUserByUsername(username: String): User? {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUserByUsername(username)
        }
    }

    override suspend fun getRoomUserByEmail(email: String): User? {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUserByEmail(email)
        }
    }

    override suspend fun getRoomUserByUsernameAndEmail(username: String, email: String): User? {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUserByUsernameAndEmail(username, email)
        }
    }

    override suspend fun getRoomUsersByUsername(username: String): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByUsername(username)
        }
    }

    override suspend fun getRoomUsersByEmail(email: String): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByEmail(email)
        }
    }

    override suspend fun getRoomUsersByUsernameAndEmail(username: String, email: String): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByUsernameAndEmail(username, email)
        }
    }

    override suspend fun getRoomUsersByUsernameOrEmail(username: String, email: String): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByUsernameOrEmail(username, email)
        }
    }

    override suspend fun getRoomUsersByUsernameAndPassword(
        username: String,
        password: String
    ): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByUsernameAndPassword(username, password)
        }
    }

    override suspend fun getRoomUsersByEmailAndPassword(email: String, password: String): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByEmailAndPassword(email, password)
        }
    }

    override suspend fun getRoomUsersByUsernameAndEmailAndPassword(
        username: String,
        email: String,
        password: String
    ): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByUsernameAndEmailAndPassword(username, email, password)
        }
    }

    override suspend fun getRoomUsersByUsernameOrEmailOrPassword(
        username: String,
        email: String,
        password: String
    ): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByUsernameOrEmailOrPassword(username, email, password)
        }
    }

    override suspend fun getRoomUsersByUsernameAndEmailOrPassword(
        username: String,
        email: String,
        password: String
    ): List<User> {
        return withContext(Dispatchers.IO) {
            db.userDao().getRoomUsersByUsernameAndEmailOrPassword(username, email, password)
        }
    }

    override suspend fun updateRoomUserByUsername(id: Int, username: String) {
        withContext(Dispatchers.IO) {
            db.userDao().updateRoomUserByUsername(id, username)
        }
    }

    override suspend fun updateRoomUserByEmail(id: Int, email: String) {
        withContext(Dispatchers.IO) {
            db.userDao().updateRoomUserByEmail(id, email)
        }
    }

    override suspend fun updateRoomUserByPassword(id: Int, password: String) {
        withContext(Dispatchers.IO) {
            db.userDao().updateRoomUserByPassword(id, password)
        }
    }

    override suspend fun updateRoomUser(id: Int, username: String, email: String, password: String) {
        withContext(Dispatchers.IO) {
            db.userDao().updateRoomUser(id, username, email, password)
        }
    }

    override suspend fun updateRoomUserDetails(id: Int, username: String, email: String) {
        withContext(Dispatchers.IO) {
            db.userDao().updateRoomUserDetails(id, username, email)
        }
    }

    override suspend fun deleteAllRoomUsers() {
        withContext(Dispatchers.IO) {
            db.userDao().deleteAllRoomUsers()
        }
    }

    override suspend fun deleteRoomUserById(id: Int) {
        withContext(Dispatchers.IO) {
            db.userDao().deleteRoomUserById(id)
        }
    }

    override suspend fun deleteRoomUserByUsername(username: String) {
        withContext(Dispatchers.IO) {
            db.userDao().deleteRoomUserByUsername(username)
        }
    }

    override suspend fun deleteRoomUserByEmail(email: String) {
        withContext(Dispatchers.IO) {
            db.userDao().deleteRoomUserByEmail(email)
        }
    }

    override suspend fun deleteRoomUserByUsernameAndEmail(username: String, email: String) {
        withContext(Dispatchers.IO) {
            db.userDao().deleteRoomUserByUsernameAndEmail(username, email)
        }
    }

    override suspend fun deleteRoomUserByUsernameOrEmail(username: String, email: String) {
        withContext(Dispatchers.IO) {
            db.userDao().deleteRoomUserByUsernameOrEmail(username, email)
        }
    }

    override suspend fun deleteRoomUserByUsernameAndEmailOrPassword(
        username: String,
        email: String,
        password: String
    ) {
        withContext(Dispatchers.IO) {
            db.userDao().deleteRoomUserByUsernameAndEmailOrPassword(username, email, password)
        }
    }
}