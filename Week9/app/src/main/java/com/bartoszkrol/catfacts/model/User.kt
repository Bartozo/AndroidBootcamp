package com.bartoszkrol.catfacts.model

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class User(
//    val _id: String,
    @Embedded val name: Name
)