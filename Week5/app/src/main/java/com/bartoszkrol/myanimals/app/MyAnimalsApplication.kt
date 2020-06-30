package com.bartoszkrol.myanimals.app

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bartoszkrol.myanimals.model.AnimalDao
import com.bartoszkrol.myanimals.model.AnimalDatabase
import com.bartoszkrol.myanimals.model.AnimalType
import com.bartoszkrol.myanimals.model.AnimalTypeDao

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
            .addCallback(roomDatabaseCallback).build()
    }

    private val roomDatabaseCallback = object : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            PopulareDbAsync(database).execute()
        }
    }

    private class PopulareDbAsync(db: AnimalDatabase) : AsyncTask<Void, Void, Void>() {
        private val animalTypeDao: AnimalTypeDao = db.animalTypeDao()

        override fun doInBackground(vararg params: Void): Void? {
            var animalType = AnimalType(AnimalType.DOG)
            animalTypeDao.insert(animalType)

            animalType = AnimalType(AnimalType.CAT)
            animalTypeDao.insert(animalType)

            animalType = AnimalType(AnimalType.BIRD)
            animalTypeDao.insert(animalType)

            animalType = AnimalType(AnimalType.Other)
            animalTypeDao.insert(animalType)

            return null
        }
    }

}