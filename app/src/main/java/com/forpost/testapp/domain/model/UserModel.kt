package com.forpost.testapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    val name: String?,
    val lastName: String?,
    val userImageIcon: String?,
    val userImageLargePhoto: String?,
    val country: String?,
    val state: String?,
    val city: String?,
    val email: String?,
    val phone: String?,
    val age: Int?
): Parcelable