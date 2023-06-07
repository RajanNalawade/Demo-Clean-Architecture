package com.example.democleanarchitecture.di

import android.content.Context
import androidx.room.Room
import com.example.democleanarchitecture.database.UserDatabase
import com.example.democleanarchitecture.database.daos.UserDAO
import com.example.democleanarchitecture.utils.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UserDatabaseModule {

    @Provides
    fun provideUserDAO(db: UserDatabase) : UserDAO{
        return db.getUserDao()
    }

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context) : UserDatabase{
        return Room.databaseBuilder(context, UserDatabase::class.java, "user_database")
            .build()
    }
}