package com.example.mc_quiz.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mc_quiz.data.AppDatabase
import com.example.mc_quiz.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database =
            AppDatabase.getDatabase(this)

        val userDao =
            database.userDao()

        setContent {
            AppNavigation(userDao)
        }
    }

}
