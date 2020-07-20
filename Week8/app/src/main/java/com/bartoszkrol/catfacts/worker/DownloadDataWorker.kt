package com.bartoszkrol.catfacts.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bartoszkrol.catfacts.App
import com.bartoszkrol.catfacts.database.CatFactsDatabase
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.model.Success

class DownloadDataWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    private val remoteApi = App.remoteApi

    override suspend fun doWork(): Result {
        val result = remoteApi.getCatFacts()

        if (result is Success) {
            // Add new data to the database
            // LiveData will update recyclerView with a new facts about the cats
            val catFactsDao = CatFactsDatabase.getDatabase(applicationContext).catFactsDao()
            val repository = RoomRepository(catFactsDao)
            repository.insertCatFacts(result.data)

            return Result.success()
        } else {
            return Result.failure()
        }
    }

}