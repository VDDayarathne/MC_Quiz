package com.example.mc_quiz.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mc_quiz.data.User
import com.example.mc_quiz.data.UserDao
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    navController: NavController,
    userDao: UserDao
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Register")

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

                if (
                    username.isBlank() ||
                    email.isBlank() ||
                    password.isBlank()
                ) {
                    Toast.makeText(
                        context,
                        "Fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {

                    scope.launch {

                        userDao.insertUser(
                            User(
                                username = username,
                                email = email,
                                password = password
                            )
                        )

                        Toast.makeText(
                            context,
                            "Registration Successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        navController.navigate("login")
                    }
                }
            }
        ) {
            Text("Register")
        }

        TextButton(
            onClick = {
                navController.navigate("login")
            }
        ) {
            Text("Already have an account?")
        }
    }
}