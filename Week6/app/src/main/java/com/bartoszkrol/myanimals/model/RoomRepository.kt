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
     * add animal to the database (ASYNC)
     */
    override fun addAnimal(animal: Animal) {
        InsertAsyncTask(animalDao).execute(animal)
    }

    /**
     * returns all animals from the database
     */
    override fun getAnimals(): LiveData<List<Animal>> = allAnimals

    /**
     * remove animal from the database (ASYNC)
     */
    override fun removeAnimal(animal: Animal) {
        DeleteAsyncTask(animalDao).execute(animal)
    }

    /**
     * remove all animals from the database (ASYNC)
     */
    override fun removeAllAnimals() {
        val animalArray = allAnimals.value?.toTypedArray()
        if (animalArray != null) {
            DeleteAsyncTask(animalDao).execute(*animalArray)
        }
    }


    private class InsertAsyncTask internal constructor(private val dao: AnimalDao) : AsyncTask<Animal, Void, Void>() {
        override fun doInBackground(vararg params: Animal): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: AnimalDao) : AsyncTask<Animal, Void, Void>() {
        override fun doInBackground(vararg params: Animal): Void? {
            dao.removeAnimals(*params)
            return null
        }
    }

}