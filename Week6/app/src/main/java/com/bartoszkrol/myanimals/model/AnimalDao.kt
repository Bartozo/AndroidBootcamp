package com.bartoszkrol.myanimals.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDao {

    @Insert
    suspend fun insert(animal: Animal)

    @Delete
    suspend fun removeAnimals(vararg animal: Animal)

    @Update
    suspend fun updateAnimal(animal: Animal)

    @Query("SELECT * FROM animal_table")
    fun getAllAnimals(): LiveData<List<Animal>>

    @Query("SELECT * FROM animal_table WHERE id = :id")
    fun getAnimal(id: Int): LiveData<Animal>

}