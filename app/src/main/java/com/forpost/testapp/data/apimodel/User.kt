package com.forpost.testapp.data.apimodel

data class User(
    val gender: String?,
    val name: NameUser?,
    val email: String?,
    val phone: String?,
    val picture: PictureUser?,
    val location: LocationUser?,
    val dob: DayBirthday?
)