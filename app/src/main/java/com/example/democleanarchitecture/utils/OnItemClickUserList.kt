package com.example.democleanarchitecture.utils

import com.example.democleanarchitecture.database.entities.User

interface OnItemClickUserList {
    fun onUserClick(mUser: User)
}