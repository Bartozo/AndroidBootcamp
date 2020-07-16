package com.bartoszkrol.catfacts.model

import kotlinx.serialization.Serializable

@Serializable
class Name(
    val first: String,
    val last: String
)