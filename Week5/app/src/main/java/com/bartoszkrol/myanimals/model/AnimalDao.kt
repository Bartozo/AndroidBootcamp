package com.bartoszkrol.myanimals.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimalDao {

    @Insert
    fun insert(animal: Animal)

    @Delete
    fun remove(animal: Animal)

    @Query("SELECT * FROM animal_table")
    fun getAllAnimals(): LiveData<List<Animal>>
}