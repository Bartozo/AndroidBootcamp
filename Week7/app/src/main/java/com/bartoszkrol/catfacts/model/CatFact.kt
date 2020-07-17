package com.bartoszkrol.catfacts.model

import kotlinx.serialization.Serializable

/**
 * Represents a fact about cats from the API.
 */
@Serializable
data class CatFact(
    val _id: String,
    val text: String,
//    val type: String,
    val user: User? = null, // some of the values from the API has a null value for the user
    val upvotes: Int
)