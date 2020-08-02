package com.bartoszkrol.catfacts.database

import androidx.lifecycle.LiveData
import com.bartoszkrol.catfacts.model.CatFact
import org.koin.core.KoinComponent
import org.koin.core.inject

class RoomRepository : CatFactsRepository, KoinComponent {

    private val database: CatFactsDatabase by inject()

    private val allCatFacts: LiveData<List<CatFact>> = database.catFactsDao().getAllCatFacts()

    /**
     * Remove all catFacts from the database
     */
    override suspend fun removeAllCatFacts() {
        val catFactsArray = allCatFacts.value?.toTypedArray()
        if (catFactsArray != null) {
            database.catFactsDao().removeCatFacts(*catFactsArray)
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
        database.catFactsDao().insertCatFacts(catFacts)
    }

}