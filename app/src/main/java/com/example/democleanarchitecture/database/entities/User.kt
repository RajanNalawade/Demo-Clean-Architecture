package com.example.democleanarchitecture.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    var designation: String,
    var joinDate: Date,
    var isOnService: Boolean
)
