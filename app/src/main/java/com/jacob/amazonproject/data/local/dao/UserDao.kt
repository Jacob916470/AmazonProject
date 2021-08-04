package com.jacob.amazonproject.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jacob.amazonproject.data.local.entities.User

@Dao
interface UserDao {

    @Query("SELECT * from user")
    suspend fun getUser(): List<User>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("DELETE FROM user")
    suspend fun deleteAllUsers()

    /** Creamos una nueva Query la cual nos ayudara a obtener el "nameUser" y la posición del  usuario*/
    @Query("SELECT COUNT(*) FROM user WHERE name = :nameUser")
    suspend fun getUserName(nameUser: String): Int

    @Query("SELECT * FROM user WHERE mail = :email AND password = :password")
    suspend fun getLogin(email: String, password: String): User?
}