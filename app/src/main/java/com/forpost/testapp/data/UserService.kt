package com.forpost.testapp.data

import com.forpost.testapp.data.apimodel.Users
import retrofit2.http.GET

interface UserService {
    @GET("api/?results=20")
    suspend fun getUsers(): Users
}