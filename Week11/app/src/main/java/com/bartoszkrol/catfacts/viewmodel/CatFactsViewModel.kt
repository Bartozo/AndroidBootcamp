package com.bartoszkrol.catfacts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.model.CatFact
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class CatFactsViewModel : ViewModel(), KoinComponent {

    private val repository: RoomRepository by inject()

    fun getCatFacts() = repository.getAllCatFacts()

    fun removeCatFacts() = viewModelScope.launch {
        repository.removeAllCatFacts()
    }

    fun insertCatFacts(catFacts: List<CatFact>) = viewModelScope.launch {
        repository.insertCatFacts(catFacts)
    }

}