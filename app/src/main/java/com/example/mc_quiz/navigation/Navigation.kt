package com.example.mc_quiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mc_quiz.data.UserDao
import com.example.mc_quiz.screens.HomeScreen
import com.example.mc_quiz.screens.LoginScreen
import com.example.mc_quiz.screens.RegisterScreen

@Composable
fun AppNavigation(userDao: UserDao) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "register"
    ) {

        composable("register") {
            RegisterScreen(navController, userDao)
        }

        composable("login") {
            LoginScreen(navController, userDao)
        }

        composable(
            route = "home/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->

            val username =
                backStackEntry.arguments?.getString("username") ?: ""

            HomeScreen(navController, username)
        }
    }
}
