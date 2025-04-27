package com.hamdi.carpooling.dataBase.roomDB

interface RoomUserRepository {
    // CRUD Operations:
    // 1-Create/Insert Operations:
    suspend fun insertUser(user: User)

    suspend fun insertUsers(users: List<User>)

    suspend fun insertUser(username: String, email: String, password: String)

    // 2- Read/Select Operations:
    suspend fun getUser(username: String, password: String): User?

    fun getAllUsers(): List<User>

    suspend fun getUserById(id: Int): User?

    suspend fun getUserByUsername(username: String): User?

    suspend fun getUserByEmail(email: String): User?

    suspend fun getUserByUsernameAndEmail(username: String, email: String): User?

    suspend fun getUsersByUsername(username: String): List<User>

    suspend fun getUsersByEmail(email: String): List<User>

    suspend fun getUsersByUsernameAndEmail(username: String, email: String): List<User>

    suspend fun getUsersByUsernameOrEmail(username: String, email: String): List<User>

    suspend fun getUsersByUsernameAndPassword(username: String, password: String): List<User>

    suspend fun getUsersByEmailAndPassword(email: String, password: String): List<User>

    suspend fun getUsersByUsernameAndEmailAndPassword(username: String, email: String, password: String): List<User>

    suspend fun getUsersByUsernameOrEmailOrPassword(username: String, email: String, password: String): List<User>

    suspend fun getUsersByUsernameAndEmailOrPassword(username: String, email: String, password: String): List<User>

    // 3- Update Operations:
    suspend fun updateUsername(id: Int, username: String)

    suspend fun updateEmail(id: Int, email: String)

    suspend fun updatePassword(id: Int, password: String)

    suspend fun updateUser(id: Int, username: String, email: String, password: String)

    suspend fun updateUserDetails(id: Int, username: String, email: String)

    // 4- Delete Operations:
    suspend fun deleteAll()

    suspend fun deleteById(id: Int)

    suspend fun deleteByUsername(username: String)

    suspend fun deleteByEmail(email: String)

    suspend fun deleteByUsernameAndEmail(username: String, email: String)

    suspend fun deleteByUsernameOrEmail(username: String, email: String)

    suspend fun deleteByUsernameAndEmailOrPassword(username: String, email: String, password: String)
}