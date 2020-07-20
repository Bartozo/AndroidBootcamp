package com.bartoszkrol.catfacts.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bartoszkrol.catfacts.App

class DownloadDataWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    private val remoteApi = App.remoteApi

    override suspend fun doWork(): Result {
        return Result.success()
    }

}