package com.example.democleanarchitecture.utils

import androidx.lifecycle.LiveData
import com.example.democleanarchitecture.database.daos.UserDAO
import com.example.democleanarchitecture.database.entities.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val mUserDAO: UserDAO) {

    suspend fun insertUser(mUser: User){
        mUserDAO.insertUser(mUser)
    }

    suspend fun deleteUser(mUser: User){
        mUserDAO.deleteUser(mUser)
    }

    suspend fun updateUser(mUser: User){
        mUserDAO.updateUser(mUser)
    }

    fun getUsers() : LiveData<List<User>>{
        return mUserDAO.getUsers()
    }
}