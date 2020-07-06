package com.bartoszkrol.myanimals.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimalTypeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(animalType: AnimalType)

    @Query("SELECT * FROM animal_type_table ORDER BY animalType ASC")
    fun getAllAnimalTypes(): LiveData<List<AnimalType>>

}