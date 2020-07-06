package com.bartoszkrol.myanimals.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bartoszkrol.myanimals.app.Injection
import com.bartoszkrol.myanimals.model.Animal

class AnimalsViewModel(application: Application): AndroidViewModel(application) {
    private val repository = Injection.provideAnimalRepository()

    fun getAnimals() = repository.getAnimals()

    fun insert(animal: Animal) = repository.addAnimal(animal)

    fun removeAnimal(animal: Animal) = repository.removeAnimal(animal)

    fun removeAnimals() = repository.removeAllAnimals()

}