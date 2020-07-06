package com.bartoszkrol.myanimals.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_type_table")
data class AnimalType(@PrimaryKey val animalType: String) {

    companion object {
        const val DOG = "Dog"
        const val CAT = "Cat"
        const val BIRD = "Bird"
        const val Other = "Other"
    }
}