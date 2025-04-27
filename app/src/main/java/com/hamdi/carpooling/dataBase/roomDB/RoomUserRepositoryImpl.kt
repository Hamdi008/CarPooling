package com.hamdi.carpooling.dataBase.roomDB

import javax.inject.Inject

class RoomUserRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : RoomUserRepository {
    override suspend fun insertUser(user: User) {
        db.userDao().insertUser(user)
    }

    override suspend fun insertUser(username: String, email: String, password: String) {
        db.userDao().insertUser(username, email, password)
    }

    override suspend fun insertUsers(users: List<User>) {
        db.userDao().insertUsers(users)
    }

    override suspend fun getUser(username: String, password: String): User? {
        return db.userDao().getUser(username, password)
    }

    override fun getAllUsers(): List<User> {
        return db.userDao().getAllUsers()
    }

    override suspend fun getUserById(id: Int): User? {
        return db.userDao().getUserById(id)
    }

    override suspend fun getUserByUsername(username: String): User? {
        return db.userDao().getUserByUsername(username)
    }

    override suspend fun getUserByEmail(email: String): User? {
        return db.userDao().getUserByEmail(email)
    }

    override suspend fun getUserByUsernameAndEmail(username: String, email: String): User? {
        return db.userDao().getUserByUsernameAndEmail(username, email)
    }

    override suspend fun getUsersByUsername(username: String): List<User> {
        return db.userDao().getUsersByUsername(username)
    }

    override suspend fun getUsersByEmail(email: String): List<User> {
        return db.userDao().getUsersByEmail(email)
    }

    override suspend fun getUsersByUsernameAndEmail(username: String, email: String): List<User> {
        return db.userDao().getUsersByUsernameAndEmail(username, email)
    }

    override suspend fun getUsersByUsernameOrEmail(username: String, email: String): List<User> {
        return db.userDao().getUsersByUsernameOrEmail(username, email)
    }

    override suspend fun getUsersByUsernameAndPassword(username: String, password: String): List<User> {
        return db.userDao().getUsersByUsernameAndPassword(username, password)
    }

    override suspend fun getUsersByEmailAndPassword(email: String, password: String): List<User> {
        return db.userDao().getUsersByEmailAndPassword(email, password)
    }

    override suspend fun getUsersByUsernameAndEmailAndPassword(
        username: String,
        email: String,
        password: String
    ): List<User> {
        return db.userDao().getUsersByUsernameAndEmailAndPassword(username, email, password)
    }

    override suspend fun getUsersByUsernameOrEmailOrPassword(
        username: String,
        email: String,
        password: String
    ): List<User> {
        return db.userDao().getUsersByUsernameOrEmailOrPassword(username, email, password)
    }

    override suspend fun getUsersByUsernameAndEmailOrPassword(
        username: String,
        email: String,
        password: String
    ): List<User> {
        return db.userDao().getUsersByUsernameAndEmailOrPassword(username, email, password)
    }

    override suspend fun updateUsername(id: Int, username: String) {
        db.userDao().updateUsername(id, username)
    }

    override suspend fun updateEmail(id: Int, email: String) {
        db.userDao().updateEmail(id, email)
    }

    override suspend fun updatePassword(id: Int, password: String) {
        db.userDao().updatePassword(id, password)
    }

    override suspend fun updateUser(id: Int, username: String, email: String, password: String) {
        db.userDao().updateUser(id, username, email, password)
    }

    override suspend fun updateUserDetails(id: Int, username: String, email: String) {
        db.userDao().updateUserDetails(id, username, email)
    }

    override suspend fun deleteAll() {
        db.userDao().deleteAll()
    }

    override suspend fun deleteById(id: Int) {
        db.userDao().deleteById(id)
    }

    override suspend fun deleteByUsername(username: String) {
        db.userDao().deleteByUsername(username)
    }

    override suspend fun deleteByEmail(email: String) {
        db.userDao().deleteByEmail(email)
    }

    override suspend fun deleteByUsernameAndEmail(username: String, email: String) {
        db.userDao().deleteByUsernameAndEmail(username, email)
    }

    override suspend fun deleteByUsernameOrEmail(username: String, email: String) {
        db.userDao().deleteByUsernameOrEmail(username, email)
    }

    override suspend fun deleteByUsernameAndEmailOrPassword(username: String, email: String, password: String) {
        db.userDao().deleteByUsernameAndEmailOrPassword(username, email, password)
    }
}