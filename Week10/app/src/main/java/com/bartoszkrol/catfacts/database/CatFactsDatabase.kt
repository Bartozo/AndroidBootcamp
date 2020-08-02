package com.bartoszkrol.catfacts.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bartoszkrol.catfacts.model.CatFact

@Database(entities = [CatFact::class], version = 1)
abstract class CatFactsDatabase : RoomDatabase() {

    abstract fun catFactsDao(): CatFactsDao

}