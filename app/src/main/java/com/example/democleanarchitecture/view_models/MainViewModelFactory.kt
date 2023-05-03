package com.example.democleanarchitecture.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.democleanarchitecture.utils.UserRepository

class MainViewModelFactory(private val mUserRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(mUserRepository) as T
    }
}