package com.bartoszkrol.myanimals.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimalDao {

    @Insert
    suspend fun insert(animal: Animal)

    @Delete
    suspend fun removeAnimals(vararg animal: Animal)

    @Query("SELECT * FROM animal_table")
    fun getAllAnimals(): LiveData<List<Animal>>
}