package com.bartoszkrol.myanimals.app

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bartoszkrol.myanimals.model.AnimalDatabase
import com.bartoszkrol.myanimals.model.AnimalType
import com.bartoszkrol.myanimals.model.AnimalTypeDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MyAnimalsApplication : Application() {

    companion object {
        lateinit var database: AnimalDatabase

        private lateinit var instance: MyAnimalsApplication

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()

        database = Room.databaseBuilder(this, AnimalDatabase::class.java, "animal_database")
            .addCallback(AnimalDatabaseCallback(GlobalScope)).build()
    }

    private class AnimalDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            scope.launch {
                val animalTypeDao = database.animalTypeDao()
                populateDb(animalTypeDao)
            }
        }

        private suspend fun populateDb(animalTypeDao: AnimalTypeDao) {
            var animalType = AnimalType(AnimalType.DOG)
            animalTypeDao.insert(animalType)

            animalType = AnimalType(AnimalType.CAT)
            animalTypeDao.insert(animalType)

            animalType = AnimalType(AnimalType.BIRD)
            animalTypeDao.insert(animalType)

            animalType = AnimalType(AnimalType.Other)
            animalTypeDao.insert(animalType)
        }

    }

}