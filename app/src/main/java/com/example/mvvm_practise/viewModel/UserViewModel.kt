package com.example.mvvm_practise.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_practise.model.UserEntity
import com.example.mvvm_practise.model.UserRepository
import com.example.mvvm_practise.model.UserRoomDatabase
import kotlinx.coroutines.launch

class UserViewModel():ViewModel() {
    private val userRepository :UserRepository = UserRepository()

    private val userDatabase = UserRoomDatabase.getDatabseInstance()

    private val _userData = MutableLiveData<List<UserEntity>>()
    val userData : LiveData<List<UserEntity>> = _userData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading


    fun getUserData(){
        _isLoading.postValue(true)
        viewModelScope.launch {
         //   val userResult = userRepository.getUserData()
             val userResult = userDatabase.userDao().getAllUsers()

            _userData.postValue(userResult)
            _isLoading.postValue(false)
        }

    }

}