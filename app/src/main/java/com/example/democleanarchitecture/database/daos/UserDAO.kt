package com.example.democleanarchitecture.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.democleanarchitecture.database.entities.User

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(mUser:User)

    @Delete
    suspend fun deleteUser(mUser: User)

    @Update
    suspend fun updateUser(mUser: User)

    @Query("SELECT * FROM user")
    fun getUsers() : LiveData<List<User>>
}