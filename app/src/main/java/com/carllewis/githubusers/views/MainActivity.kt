package com.carllewis.githubusers.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.carllewis.githubusers.R
import com.carllewis.githubusers.base.LoadingState
import com.carllewis.githubusers.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        userViewModel.data.observe(this, Observer {
            // Todo: Populate the recyclerView here
            it.forEach { githubUser ->
                Log.i("MainActivity", githubUser.login)
            }
        })

        userViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.ERROR -> Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
                LoadingState.Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}