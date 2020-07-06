package com.bartoszkrol.myanimals.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bartoszkrol.myanimals.app.MyAnimalsApplication

class AnimalTypeViewModel(application: Application) : AndroidViewModel(application) {
    private val animalTypeDao = MyAnimalsApplication.database.animalTypeDao()

    fun getAnimalTypes() = animalTypeDao.getAllAnimalTypes()

}