package com.jacob.amazonproject.data.repositories

import com.jacob.amazonproject.data.dao.UserDao
import com.jacob.amazonproject.data.entities.User

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun insertUser(user: User): Long = userDao.insertUser(user)

    suspend fun deleteAllUsers() = userDao.deleteAllUsers()

}