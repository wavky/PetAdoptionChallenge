package com.example.androiddevchallenge.domain

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pet(
    @DrawableRes val imageId: Int,
    val name: String,
    val age: String,
    val gender: Gender,
    val nationality: String,
    val favoriteFood: String,
    val message: String
): Parcelable {
    enum class Gender {
        Male, Female
    }
}