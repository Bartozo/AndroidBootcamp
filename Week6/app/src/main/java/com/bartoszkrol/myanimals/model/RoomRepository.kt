package com.bartoszkrol.myanimals.model

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.bartoszkrol.myanimals.app.MyAnimalsApplication

class RoomRepository : AnimalRepository {

    private val animalDao: AnimalDao = MyAnimalsApplication.database.animalDao()
    private val allAnimals: LiveData<List<Animal>>

    init {
        allAnimals = animalDao.getAllAnimals()
    }

    /**
     * add animal to the database (using Coroutines)
     */
    override suspend fun addAnimal(animal: Animal) {
        animalDao.insert(animal)
    }

    /**
     * returns all animals from the database
     */
    override fun getAnimals(): LiveData<List<Animal>> = allAnimals

    /**
     * remove animal from the database (using Coroutines)
     */
    override suspend fun removeAnimal(animal: Animal) {
        animalDao.removeAnimals(animal)
    }

    /**
     * remove all animals from the database (using Coroutines)
     */
    override suspend fun removeAllAnimals() {
        val animalArray = allAnimals.value?.toTypedArray()
        if (animalArray != null) {
            animalDao.removeAnimals(*animalArray)
        }
    }

}