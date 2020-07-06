package com.bartoszkrol.myanimals.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(Animal::class), (AnimalType::class)], version = 1)
abstract class AnimalDatabase : RoomDatabase() {

    abstract fun animalDao(): AnimalDao

    abstract fun animalTypeDao(): AnimalTypeDao
}