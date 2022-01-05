package com.carllewis.githubusers.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carllewis.githubusers.database.UserRepo
import com.carllewis.githubusers.viewmodels.UserViewModel
import java.lang.IllegalArgumentException

class UserViewModelFactory constructor(private val userRepo: UserRepo): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass){
        UserViewModel::class.java -> UserViewModel(userRepo)
        else -> throw IllegalArgumentException("Unknown ViewModel Class")
    } as T

}