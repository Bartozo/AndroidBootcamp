package com.bartoszkrol.catfacts.di

import com.bartoszkrol.catfacts.networking.buildApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    // Base url
    single(named("BASE_URL")) {
        "https://cat-fact.herokuapp.com"
    }

    // Api service Builder
    single {
        buildApiService(get<String>(named("BASE_URL")))
    }
}