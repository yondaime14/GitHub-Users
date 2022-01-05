package com.carllewis.githubusers.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey
    val id: Long,
    val login: String,
    val avatar_url: String,
    val url: String
)
