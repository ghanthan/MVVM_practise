package com.example.mvvm_practise.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetails")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val age : Int
)
