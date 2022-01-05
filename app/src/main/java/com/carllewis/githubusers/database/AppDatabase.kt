package com.carllewis.githubusers.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carllewis.githubusers.models.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract val userDao: UserDao
}