package com.forpost.testapp.extention

import com.forpost.testapp.data.apimodel.Users
import com.forpost.testapp.domain.model.UserModel


fun Users.toUserInfoList(): List<UserModel> =
    arrayListOf<UserModel>().apply {
        this@toUserInfoList.results.forEach { user ->
            this.add(
                UserModel(
                    user.name?.first,
                    user.name?.last,
                    user.picture?.medium,
                    user.picture?.large,
                    user.location?.country,
                    user.location?.state,
                    user.location?.city,
                    user.email,
                    user.phone,
                    user.dob?.age
                )
            )
        }
    }
