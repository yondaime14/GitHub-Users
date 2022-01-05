package com.carllewis.githubusers.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carllewis.githubusers.base.LoadingState
import com.carllewis.githubusers.database.UserRepo
import kotlinx.coroutines.launch
import org.koin.androidx.compose.viewModel
import java.lang.Exception

class UserViewModel constructor(private val userRepo: UserRepo) : ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()

    val data = userRepo.liveUserData

    val loadingState: LiveData<LoadingState> get() = loadingState

    init {
        fetchUserData()
    }

    private fun fetchUserData() {

        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                userRepo.reFreshData()
                _loadingState.value = LoadingState.SUCCESS
            } catch (e: Exception) {

                _loadingState.value = LoadingState.error(e.message)
            }
        }

    }

}