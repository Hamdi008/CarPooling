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
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<User>)

    @Query("INSERT INTO users_table (username, email, password) VALUES (:username, :email, :password)")
    suspend fun insertUser(username: String, email: String, password: String)

    // 2- Read/Select Operations:
    @Query("SELECT * FROM users_table WHERE username = :username AND password = :password")
    suspend fun getUser(username: String, password: String): User?

    @Query("SELECT * FROM users_table")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users_table WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM users_table WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM users_table WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users_table WHERE username = :username AND email = :email")
    suspend fun getUserByUsernameAndEmail(username: String, email: String): User?

    @Query("SELECT * FROM users_table WHERE username LIKE :username")
    suspend fun getUsersByUsername(username: String): List<User>

    @Query("SELECT * FROM users_table WHERE email LIKE :email")
    suspend fun getUsersByEmail(email: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND email LIKE :email")
    suspend fun getUsersByUsernameAndEmail(username: String, email: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username OR email LIKE :email")
    suspend fun getUsersByUsernameOrEmail(username: String, email: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND password LIKE :password")
    suspend fun getUsersByUsernameAndPassword(username: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE email LIKE :email AND password LIKE :password")
    suspend fun getUsersByEmailAndPassword(email: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND email LIKE :email AND password LIKE :password")
    suspend fun getUsersByUsernameAndEmailAndPassword(username: String, email: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username OR email LIKE :email OR password LIKE :password")
    suspend fun getUsersByUsernameOrEmailOrPassword(username: String, email: String, password: String): List<User>

    @Query("SELECT * FROM users_table WHERE username LIKE :username AND (email LIKE :email OR password LIKE :password)")
    suspend fun getUsersByUsernameAndEmailOrPassword(username: String, email: String, password: String): List<User>

    // 3- Update Operations:
    @Query("UPDATE users_table SET username = :username WHERE id = :id")
    suspend fun updateUsername(id: Int, username: String)

    @Query("UPDATE users_table SET email = :email WHERE id = :id")
    suspend fun updateEmail(id: Int, email: String)

    @Query("UPDATE users_table SET password = :password WHERE id = :id")
    suspend fun updatePassword(id: Int, password: String)

    @Query("UPDATE users_table SET username = :username, email = :email, password = :password WHERE id = :id")
    suspend fun updateUser(id: Int, username: String, email: String, password: String)

    @Query("UPDATE users_table SET username = :username, email = :email WHERE id = :id")
    suspend fun updateUserDetails(id: Int, username: String, email: String)

    // 4- Delete Operations:
    @Query("DELETE FROM users_table")
    suspend fun deleteAll()

    @Query("DELETE FROM users_table WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM users_table WHERE username = :username")
    suspend fun deleteByUsername(username: String)

    @Query("DELETE FROM users_table WHERE email = :email")
    suspend fun deleteByEmail(email: String)

    @Query("DELETE FROM users_table WHERE username = :username AND email = :email")
    suspend fun deleteByUsernameAndEmail(username: String, email: String)

    @Query("DELETE FROM users_table WHERE username = :username OR email = :email")
    suspend fun deleteByUsernameOrEmail(username: String, email: String)

    @Query("DELETE FROM users_table WHERE username = :username AND email = :email OR password = :password")
    suspend fun deleteByUsernameAndEmailOrPassword(username: String, email: String, password: String)
}