package com.forpost.testapp.domain.usecase

import com.forpost.testapp.data.apimodel.Users
import com.forpost.testapp.data.repostitory.UserRepository
import com.forpost.testapp.domain.model.UserModel
import com.forpost.testapp.extention.toUserInfoList


class UserListUseCase(private val userRepository: UserRepository) {

    suspend fun getUsers(): List<UserModel> =
        userRepository.getUsers().toUserInfoList()
}

