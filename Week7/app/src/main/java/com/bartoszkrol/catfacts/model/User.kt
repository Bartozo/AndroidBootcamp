package com.bartoszkrol.catfacts.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val _id: String,
    val name: Name
)