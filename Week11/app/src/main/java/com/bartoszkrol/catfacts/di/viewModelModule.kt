package com.bartoszkrol.catfacts.di

import com.bartoszkrol.catfacts.viewmodel.CatFactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
/**
 * ViewModel module used for a DI
 */
val viewModelModule = module {

    // ViewModel
    viewModel {
        CatFactsViewModel()
    }

}