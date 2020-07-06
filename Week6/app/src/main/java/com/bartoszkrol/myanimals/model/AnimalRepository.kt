package com.bartoszkrol.myanimals.model

import androidx.lifecycle.LiveData

interface AnimalRepository {
    suspend fun addAnimal(animal: Animal)
    fun getAnimals(): LiveData<List<Animal>>
    suspend fun removeAnimal(animal: Animal)
    suspend fun removeAllAnimals()
}