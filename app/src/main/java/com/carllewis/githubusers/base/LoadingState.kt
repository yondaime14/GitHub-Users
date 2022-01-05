package com.carllewis.githubusers.base

import androidx.lifecycle.MutableLiveData

data class LoadingState constructor(val status:Status, val message: String? = null) {

    companion object {

        val SUCCESS = LoadingState(Status.SUCCESS)
        val LOADING = LoadingState(Status.RUNNING)
        fun error(message: String?) = LoadingState(Status.ERROR, message)
    }


    enum class Status {

        RUNNING,
        SUCCESS,
        ERROR
    }
}

