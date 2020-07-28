package com.bartoszkrol.catfacts.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.model.CatFact
import kotlinx.coroutines.launch

class CatFactsViewModel(repository: RoomRepository) : ViewModel() {

    fun getCatFacts() = App.repository.getAllCatFacts()

    fun removeCatFacts() = viewModelScope.launch {
        App.repository.removeAllCatFacts()
    }

    fun insertCatFacts(catFacts: List<CatFact>) = viewModelScope.launch {
        App.repository.insertCatFacts(catFacts)
    }

}