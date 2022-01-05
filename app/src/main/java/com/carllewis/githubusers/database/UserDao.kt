package com.carllewis.githubusers.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carllewis.githubusers.models.Users

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun findAll(): LiveData<List<Users>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(users: List<Users>)
}