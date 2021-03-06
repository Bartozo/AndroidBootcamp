package com.bartoszkrol.catfacts

import android.app.Application
import androidx.work.*
import com.bartoszkrol.catfacts.di.networkModule
import com.bartoszkrol.catfacts.di.repositoryModule
import com.bartoszkrol.catfacts.di.viewModelModule
import com.bartoszkrol.catfacts.worker.DownloadDataWorker
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.concurrent.TimeUnit


class App : Application() {

    companion object {
        private lateinit var instance: App

        fun getAppContext() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startDownloadingDataWorker()
        startKoinModules()
    }

    /**
     * Starts a worker that downloads a data from the API server every 1 hour.
     * This is a unique worker, so there will be only 1 instance of it.
     */
    private fun startDownloadingDataWorker() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .build()

        val work = PeriodicWorkRequestBuilder<DownloadDataWorker>(1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        val workManager = WorkManager.getInstance(this)
        workManager.enqueueUniquePeriodicWork(
            DownloadDataWorker.DOWNLOAD_DATA_WORKER,
            ExistingPeriodicWorkPolicy.KEEP,
            work
        )
    }

    /**
     * Creates modules for a DI
     */
    private fun startKoinModules() {
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }

}