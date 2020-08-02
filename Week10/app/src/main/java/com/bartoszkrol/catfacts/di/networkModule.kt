package com.bartoszkrol.catfacts.di

import com.bartoszkrol.catfacts.networking.RemoteApi
import com.bartoszkrol.catfacts.networking.buildApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Network module used for a DI
 */
val networkModule = module {
    // Base url
    single(named("BASE_URL")) {
        "https://cat-fact.herokuapp.com"
    }

    // API service Builder
    single {
        buildApiService(get<String>(named("BASE_URL")))
    }

    // Remote API
    single {
        RemoteApi(get())
    }

}