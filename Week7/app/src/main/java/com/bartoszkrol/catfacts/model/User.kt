package com.bartoszkrol.catfacts.model

import androidx.room.Embedded
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @Embedded val name: Name
)