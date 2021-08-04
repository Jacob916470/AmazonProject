package com.jacob.amazonproject.data.repositories

import com.jacob.amazonproject.data.dao.UserDao
import com.jacob.amazonproject.data.entities.User

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun insertUser(user: User): Long = userDao.insertUser(user)

    suspend fun deleteAllUsers() = userDao.deleteAllUsers()

    /** Creamos "suspend fun getUserName" para poder obtener un String y a su ves un Int para poder validar
     * si ya es un usuario ya esta registrado*/
    suspend fun getUserName(nameUser : String) = userDao.getUserName(nameUser = nameUser)

    suspend fun getLogin(email: String, password: String): User?{
        return userDao.getLogin(email,password)
    }

}