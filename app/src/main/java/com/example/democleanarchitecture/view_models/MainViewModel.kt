package com.example.democleanarchitecture.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democleanarchitecture.database.entities.User
import com.example.democleanarchitecture.utils.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun insertUser(mUser: User){
        viewModelScope.launch {
            userRepository.insertUser(mUser)
        }
    }

    fun deleteUser(mUser: User){

        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(mUser)
        }
    }

    fun updateUser(mUser: User){
        viewModelScope.launch {
            userRepository.updateUser(mUser)
        }
    }

    fun getUsers() : LiveData<List<User>>{
        return userRepository.getUsers()
    }
}