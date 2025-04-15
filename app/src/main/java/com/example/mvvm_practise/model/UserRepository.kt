package com.example.mvvm_practise.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUserData():UserData{
        delay(3000)
        return UserData("John",30)
    }
}