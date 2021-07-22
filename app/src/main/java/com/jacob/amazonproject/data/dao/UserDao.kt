package com.jacob.amazonproject.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jacob.amazonproject.data.entities.User

@Dao
interface UserDao {

    @Query("SELECT * from user")
    suspend fun getUser(): List<User>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAllUsers()
}