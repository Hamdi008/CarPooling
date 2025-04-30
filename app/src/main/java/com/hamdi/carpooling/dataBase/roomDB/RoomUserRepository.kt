package com.hamdi.carpooling.dataBase.roomDB

interface RoomUserRepository {
    // CRUD Operations:
    // 1-Create/Insert Operations:
    suspend fun insertRoomUser(user: User)

    suspend fun insertRoomUsers(users: List<User>)

    suspend fun insertRoomUser(username: String, email: String, password: String)

    // 2- Read/Select Operations:
    suspend fun getRoomUser(username: String, password: String): User?

    suspend fun getAllRoomUsers(): List<User>

    suspend fun getRoomUserById(id: Int): User?

    suspend fun getRoomUserByUsername(username: String): User?

    suspend fun getRoomUserByEmail(email: String): User?

    suspend fun getRoomUserByUsernameAndEmail(username: String, email: String): User?

    suspend fun getRoomUsersByUsername(username: String): List<User>

    suspend fun getRoomUsersByEmail(email: String): List<User>

    suspend fun getRoomUsersByUsernameAndEmail(username: String, email: String): List<User>

    suspend fun getRoomUsersByUsernameOrEmail(username: String, email: String): List<User>

    suspend fun getRoomUsersByUsernameAndPassword(username: String, password: String): List<User>

    suspend fun getRoomUsersByEmailAndPassword(email: String, password: String): List<User>

    suspend fun getRoomUsersByUsernameAndEmailAndPassword(username: String, email: String, password: String): List<User>

    suspend fun getRoomUsersByUsernameOrEmailOrPassword(username: String, email: String, password: String): List<User>

    suspend fun getRoomUsersByUsernameAndEmailOrPassword(username: String, email: String, password: String): List<User>

    // 3- Update Operations:
    suspend fun updateRoomUserByUsername(id: Int, username: String)

    suspend fun updateRoomUserByEmail(id: Int, email: String)

    suspend fun updateRoomUserByPassword(id: Int, password: String)

    suspend fun updateRoomUser(id: Int, username: String, email: String, password: String)

    suspend fun updateRoomUserDetails(id: Int, username: String, email: String)

    // 4- Delete Operations:
    suspend fun deleteAllRoomUsers()

    suspend fun deleteRoomUserById(id: Int)

    suspend fun deleteRoomUserByUsername(username: String)

    suspend fun deleteRoomUserByEmail(email: String)

    suspend fun deleteRoomUserByUsernameAndEmail(username: String, email: String)

    suspend fun deleteRoomUserByUsernameOrEmail(username: String, email: String)

    suspend fun deleteRoomUserByUsernameAndEmailOrPassword(username: String, email: String, password: String)
}