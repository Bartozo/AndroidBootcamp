package com.bartoszkrol.catfacts.model

import kotlinx.serialization.Serializable

/**
 * Represents a fact about cats from the API.
 */
@Serializable
data class CatFact(
    val _id: String,
    val text: String,
    val type: String,
    val user: User,
    val upvotes: Int
)