package com.bartoszkrol.catfacts.database

import androidx.lifecycle.LiveData
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.model.CatFact

class RoomRepository  : CatFactsRepository {

    private val catFactsDao: CatFactsDao = App.database.catFactsDao()
    private val allCatFacts: LiveData<List<CatFact>>

    init {
        allCatFacts = catFactsDao.getAllCatFacts()
    }

    /**
     * Remove all catFacts from the database
     */
    override suspend fun removeAllCatFacts() {
        val catFactsArray = allCatFacts.value?.toTypedArray()
        if (catFactsArray != null) {
            catFactsDao.removeCatFacts(*catFactsArray)
        }
    }

    /**
     * Get all catFacts from the database
     */
    override fun getAllCatFacts(): LiveData<List<CatFact>> = allCatFacts

    /**
     * Insert catFacts to the database
     */
    override suspend fun insertCatFacts(catFacts: List<CatFact>) {
        catFactsDao.insertCatFacts(catFacts)
    }

}