package com.pereyrarg11.instagramcomposable.recyclerview.model

import androidx.annotation.DrawableRes

data class Superhero(
    val name: String,
    val realName: String,
    val publisher: String,
    @DrawableRes val photo: Int,
)
