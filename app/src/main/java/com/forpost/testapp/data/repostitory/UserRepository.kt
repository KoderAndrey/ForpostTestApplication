package com.forpost.testapp.data.repostitory

import com.forpost.testapp.data.apimodel.Users
import org.koin.core.KoinComponent

interface UserRepository: KoinComponent {

    suspend fun getUsers(): Users
}