package com.bartoszkrol.catfacts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.database.CatFactsRepository
import com.bartoszkrol.catfacts.model.CatFact
import kotlinx.coroutines.launch

class CatFactsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CatFactsRepository = App.provideCatFactsRepository()

    fun getCatFacts() = repository.getAllCatFacts()

    fun removeCatFacts() = viewModelScope.launch {
        repository.removeAllCatFacts()
    }

    fun insertCatFacts(catFacts: List<CatFact>) = viewModelScope.launch {
        repository.insertCatFacts(catFacts)
    }

}