package com.bartoszkrol.catfacts.di

import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.networking.NetworkStatusChecker
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

    // Network Status module
    // No't sure if this should be single or factory
    // I have only 1 Activity that uses this class, but what If I will add more activities that
    // require to check internet connection
    factory {
        NetworkStatusChecker(getSystemService(App.getAppContext(), ConnectivityManager::class.java))
    }

}