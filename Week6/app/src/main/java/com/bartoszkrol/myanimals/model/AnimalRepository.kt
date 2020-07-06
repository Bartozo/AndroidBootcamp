package com.bartoszkrol.myanimals.model

import androidx.lifecycle.LiveData

interface AnimalRepository {
    fun addAnimal(animal: Animal)
    fun getAnimals(): LiveData<List<Animal>>
    fun removeAnimal(animal: Animal)
    fun removeAllAnimals()
}