package com.bartoszkrol.catfacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bartoszkrol.catfacts.model.CatFact

@Database(entities = [CatFact::class], version = 1)
abstract class CatFactsDatabase : RoomDatabase() {

    abstract fun catFactsDao(): CatFactsDao

    companion object {
        @Volatile
        private var INSTANCE: CatFactsDatabase? = null

        fun getDatabase(context: Context): CatFactsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatFactsDatabase::class.java,
                    "catfacts_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}