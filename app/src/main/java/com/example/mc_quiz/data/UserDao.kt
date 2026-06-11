package com.example.mc_quiz.data

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query(
        "SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1"
    )
    suspend fun loginUser(
        username: String,
        password: String
    ): User?

}