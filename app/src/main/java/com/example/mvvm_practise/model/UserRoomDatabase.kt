package com.example.mvvm_practise.model

import androidx.room.Room
import androidx.room.RoomDatabase

abstract class UserRoomDatabase: RoomDatabase() {


    abstract fun userDao(): UserDao


    companion object{

        private var INSTANCE : UserRoomDatabase ?= null

        fun getDatabseInstance(): UserRoomDatabase {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}