package com.bartoszkrol.catfacts.database

import androidx.lifecycle.LiveData
import com.bartoszkrol.catfacts.model.CatFact

interface CatFactsRepository  {
    suspend fun removeAllCatFacts()
    fun getAllCatFacts(): LiveData<List<CatFact>>
    suspend fun insertCatFacts(catFacts: List<CatFact>)
}