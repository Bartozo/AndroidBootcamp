package com.bartoszkrol.catfacts

import android.app.Application
import com.bartoszkrol.catfacts.database.CatFactsDatabase
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.networking.RemoteApi
import com.bartoszkrol.catfacts.networking.buildApiService

class App : Application() {

    companion object {
        private lateinit var instance: App

        private val apiService by lazy { buildApiService() }

        val remoteApi by lazy { RemoteApi(apiService) }

        private val catDao by lazy {
            CatFactsDatabase.getDatabase(instance).catFactsDao()
        }

        val repository: RoomRepository by lazy {
            RoomRepository(catDao)
        }

        fun getAppContext() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}