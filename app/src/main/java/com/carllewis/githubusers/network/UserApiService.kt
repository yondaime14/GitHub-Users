package com.carllewis.githubusers.network

import com.carllewis.githubusers.models.Users
import com.carllewis.githubusers.utils.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApiService {

    @GET("/users")
    suspend fun getAllUsers(): List<Users>

    companion object {
        var userApiService: UserApiService? = null

        fun getInstance() : UserApiService {

            if (userApiService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                userApiService = retrofit.create(UserApiService::class.java)
            } else {
                //TODO - Log errors in api call
            }

            return userApiService!!
        }
    }
}