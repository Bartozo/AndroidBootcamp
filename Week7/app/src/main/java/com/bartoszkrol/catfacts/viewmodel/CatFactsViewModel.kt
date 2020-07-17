package com.bartoszkrol.catfacts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bartoszkrol.catfacts.database.CatFactsDatabase
import com.bartoszkrol.catfacts.database.CatFactsRepository
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.model.CatFact
import kotlinx.coroutines.launch

class CatFactsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RoomRepository

    private val allCatFacts: LiveData<List<CatFact>>

    init {
        val catFactsDao = CatFactsDatabase.getDatabase(application).catFactsDao()
        repository = RoomRepository(catFactsDao)
        allCatFacts = repository.getAllCatFacts()

    }

    fun getCatFacts() = repository.getAllCatFacts()

    fun removeCatFacts() = viewModelScope.launch {
        repository.removeAllCatFacts()
    }

    fun insertCatFacts(catFacts: List<CatFact>) = viewModelScope.launch {
        repository.insertCatFacts(catFacts)
    }

}