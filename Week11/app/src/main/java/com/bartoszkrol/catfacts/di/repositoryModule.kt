package com.bartoszkrol.catfacts.di

import androidx.room.Room
import com.bartoszkrol.catfacts.database.CatFactsDatabase
import com.bartoszkrol.catfacts.database.RoomRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Repository module used for a DI
 */
val repositoryModule = module {

    // Repository
    single {
        RoomRepository()
    }

    // Room database
    single {
        Room.databaseBuilder(androidContext(),
            CatFactsDatabase::class.java,
            "catfacts_database")
            .build()
    }

}