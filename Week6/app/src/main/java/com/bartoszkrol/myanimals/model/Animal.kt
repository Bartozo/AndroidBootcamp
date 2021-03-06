package com.bartoszkrol.myanimals.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "animal_table",
    foreignKeys = [(ForeignKey(entity = AnimalType::class,
    parentColumns = ["animalType"],
    childColumns = ["type"],
    onDelete = CASCADE))])
data class Animal(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                  val name: String,
                  val type: String = AnimalType.Other)