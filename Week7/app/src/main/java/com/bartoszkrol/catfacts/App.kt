package com.bartoszkrol.catfacts

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.bartoszkrol.catfacts.database.CatFactsDatabase
import com.bartoszkrol.catfacts.database.CatFactsRepository
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.networking.RemoteApi
import com.bartoszkrol.catfacts.networking.buildApiService

class App : Application() {

    companion object {
        private lateinit var instance: App

        private val apiService by lazy { buildApiService() }

        val remoteApi by lazy { RemoteApi(apiService) }

        lateinit var database: CatFactsDatabase

        fun getAppContext(): Context = instance.applicationContext

        fun provideCatFactsRepository(): CatFactsRepository = RoomRepository()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        database = Room.databaseBuilder(
            this,
            CatFactsDatabase::class.java,
            "catfacts_database")
            .build()
    }

}