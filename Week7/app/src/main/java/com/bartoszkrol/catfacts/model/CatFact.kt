package com.bartoszkrol.catfacts.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * Represents a fact about cats from the API.
 */
@Entity(tableName = "catFacts_table")
@Serializable
data class CatFact(
    @PrimaryKey(autoGenerate = false) val _id: String,
    val text: String,
    val user: User? = null, // some of the values from the API has a null value for the user
    val upvotes: Int
)