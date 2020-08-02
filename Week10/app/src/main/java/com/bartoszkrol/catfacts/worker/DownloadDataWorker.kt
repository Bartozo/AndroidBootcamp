package com.bartoszkrol.catfacts.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.database.CatFactsDatabase
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.model.Success
import com.bartoszkrol.catfacts.networking.RemoteApi
import org.koin.core.KoinComponent
import org.koin.core.inject

class DownloadDataWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params), KoinComponent {

    private val remoteApi: RemoteApi by inject()

    companion object {
        const val DOWNLOAD_DATA_WORKER = "DOWNLOAD_DATA_WORKER"
    }

    override suspend fun doWork(): Result {
        val result = remoteApi.getCatFacts()

        if (result is Success) {
            // Add new data to the database
            // LiveData will update recyclerView with a new facts about the cats
            App.repository.insertCatFacts(result.data)

            return Result.success()
        } else {
            return Result.failure()
        }
    }

}