package com.forpost.testapp.data.repostitory

import com.forpost.testapp.data.UserService
import com.forpost.testapp.data.apimodel.Users

class UserRepositoryIml(private val api: UserService) : UserRepository {

    override suspend fun getUsers(): Users =
        api.getUsers()

}