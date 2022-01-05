package com.carllewis.githubusers.database

import com.carllewis.githubusers.network.UserApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepo constructor(private val userApiService: UserApiService, private val userDao: UserDao) {

    //live Data
    val liveUserData = userDao.findAll()

    //offline Data
    suspend fun reFreshData(){

        withContext(Dispatchers.IO){
            val users = userApiService.getAllUsers()
            userDao.addUsers(users)
        }
    }
}