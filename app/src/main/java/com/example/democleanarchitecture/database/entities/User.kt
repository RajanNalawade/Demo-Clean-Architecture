package com.example.democleanarchitecture.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Long ,
    val name : String,
    val designation : String,
    val joinDate : Date,
    val isOnService : Boolean
)
