package com.bartoszkrol.myanimals.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "animal_table",
    foreignKeys = [(ForeignKey(entity = AnimalType::class,
    parentColumns = ["animalType"],
    childColumns = ["type"],
    onDelete = CASCADE))])
data class Animal(@PrimaryKey val id: String = UUID.randomUUID().toString(),
                  val name: String,
                  val type: String = AnimalType.Other)