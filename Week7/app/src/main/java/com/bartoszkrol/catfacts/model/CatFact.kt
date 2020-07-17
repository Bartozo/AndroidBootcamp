package com.bartoszkrol.catfacts.model

import androidx.room.Embedded
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
    @Embedded val user: User? = null,
    val upvotes: Int
)