package com.bartoszkrol.catfacts.model

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val first: String,
    val last: String
)