package com.example.democleanarchitecture.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.democleanarchitecture.database.daos.UserDAO
import com.example.democleanarchitecture.database.entities.User
import com.example.democleanarchitecture.utils.RoomConverters

@Database(entities = [User::class], version = 1)
@TypeConverters(RoomConverters::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao() : UserDAO

    companion object {
        private var userDB : UserDatabase? = null

        fun getUserDatabase(context: Context): UserDatabase {
            if (userDB == null){
                synchronized(this){
                    userDB = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database")
                        .build()
                }
            }
            return userDB!!
        }
    }
}