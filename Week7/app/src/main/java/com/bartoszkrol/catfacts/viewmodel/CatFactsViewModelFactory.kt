package com.bartoszkrol.catfacts.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bartoszkrol.catfacts.database.RoomRepository

class CatFactsViewModelFactory(val application: Application, val repository: RoomRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatFactsViewModel::class.java)) {
            return CatFactsViewModel(application, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}