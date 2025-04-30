package com.hamdi.carpooling.dataBase.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    // CRUD Operations:
    // 1-Create/Insert Operations:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoomUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoomUsers(users: List<User>)

    @Query("INSERT INTO users_table (username, email, password) VALUES (:username, :email, :password)")
    suspend fun insertRoomUser(username: String, email: String, password: String)

    // 2- Read/Select Operations:
    @Query("SELECT * FROM users_table WHERE username = :username AND password = :password")
    suspend fun getRoomUser(username: String, password: String): User?

    @Query("SELECT * FROM users_table")
    fun getAllRoomUsers(): List<User>

    @Query("SELECT * FROM users_table WHERE id = :id")
    suspend fun getRoomUserById(id: Int): User?

    @Query("SELECT * FROM users_table WHERE username = :username")
    suspend fun getRoomUserByUsername(username: String): User?

    @Query("SELECT * FROM users_table WHERE email = :email")
    suspend fun getRoomUserByEmail(email: String): User?

    @Query("SELECT * FROM users_table WHERE username = :username AND email = :email")
    suspend fun getRoomUserByUsernameAndEmail(username: String, email: String): User?

    @Query("SELECT * FROM users_table WHERE username LIKE :username")
    suspend fun getRoomUsersByUsername(username: String): List<User>

    @Query("SELECT * FROM users_table WHERE email LIKE :email")
    suspend fun getRoomUsersByEmail(email: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND email LIKE :email")
    suspend fun getRoomUsersByUsernameAndEmail(username: String, email: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username OR email LIKE :email")
    suspend fun getRoomUsersByUsernameOrEmail(username: String, email: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND password LIKE :password")
    suspend fun getRoomUsersByUsernameAndPassword(username: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE email LIKE :email AND password LIKE :password")
    suspend fun getRoomUsersByEmailAndPassword(email: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND email LIKE :email AND password LIKE :password")
    suspend fun getRoomUsersByUsernameAndEmailAndPassword(username: String, email: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username OR email LIKE :email OR password LIKE :password")
    suspend fun getRoomUsersByUsernameOrEmailOrPassword(username: String, email: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND (email LIKE :email OR password LIKE :password)")
    suspend fun getRoomUsersByUsernameAndEmailOrPassword(username: String, email: String, password: String): List<User>

    // 3- Update Operations:
    @Query("UPDATE users_table SET username = :username WHERE id = :id")
    suspend fun updateRoomUserByUsername(id: Int, username: String)

    @Query("UPDATE users_table SET email = :email WHERE id = :id")
    suspend fun updateRoomUserByEmail(id: Int, email: String)

    @Query("UPDATE users_table SET password = :password WHERE id = :id")
    suspend fun updateRoomUserByPassword(id: Int, password: String)

    @Query("UPDATE users_table SET username = :username, email = :email, password = :password WHERE id = :id")
    suspend fun updateRoomUser(id: Int, username: String, email: String, password: String)

    @Query("UPDATE users_table SET username = :username, email = :email WHERE id = :id")
    suspend fun updateRoomUserDetails(id: Int, username: String, email: String)

    // 4- Delete Operations:
    @Query("DELETE FROM users_table")
    suspend fun deleteAllRoomUsers()

    @Query("DELETE FROM users_table WHERE id = :id")
    suspend fun deleteRoomUserById(id: Int)

    @Query("DELETE FROM users_table WHERE username = :username")
    suspend fun deleteRoomUserByUsername(username: String)

    @Query("DELETE FROM users_table WHERE email = :email")
    suspend fun deleteRoomUserByEmail(email: String)

    @Query("DELETE FROM users_table WHERE username = :username AND email = :email")
    suspend fun deleteRoomUserByUsernameAndEmail(username: String, email: String)

    @Query("DELETE FROM users_table WHERE username = :username OR email = :email")
    suspend fun deleteRoomUserByUsernameOrEmail(username: String, email: String)

    @Query("DELETE FROM users_table WHERE username = :username AND email = :email OR password = :password")
    suspend fun deleteRoomUserByUsernameAndEmailOrPassword(username: String, email: String, password: String)
}