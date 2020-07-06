package com.bartoszkrol.myanimals.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bartoszkrol.myanimals.app.Injection
import com.bartoszkrol.myanimals.model.Animal
import kotlinx.coroutines.launch

class AnimalsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Injection.provideAnimalRepository()

    fun getAnimals() = repository.getAnimals()

    fun insert(animal: Animal) = viewModelScope.launch {
        repository.addAnimal(animal)
    }

    fun removeAnimal(animal: Animal) = viewModelScope.launch {
        repository.removeAnimal(animal)
    }

    fun removeAnimals() = viewModelScope.launch {
        repository.removeAllAnimals()
    }

}