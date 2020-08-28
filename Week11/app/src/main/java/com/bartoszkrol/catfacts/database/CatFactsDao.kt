package com.bartoszkrol.catfacts.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bartoszkrol.catfacts.model.CatFact

@Dao
interface CatFactsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCatFacts(catFact: List<CatFact>)

    @Delete
    suspend fun removeCatFacts(vararg catFact: CatFact)

    @Query("SELECT * FROM catfacts_table")
    fun getAllCatFacts(): LiveData<List<CatFact>>

}