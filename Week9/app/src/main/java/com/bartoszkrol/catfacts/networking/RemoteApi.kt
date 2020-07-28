package com.bartoszkrol.catfacts.networking

import com.bartoszkrol.catfacts.model.*
import java.lang.NullPointerException

/**
 * Logic for the API calls
 */

const val BASE_URL = "https://cat-fact.herokuapp.com"

class RemoteApi(private val apiService: RemoteApiService) {

    suspend fun getCatFacts(): Result<List<CatFact>> = try {
        val data = apiService.getCatFacts()

        Success(data.all)
    } catch (error: Throwable) {
        Failure(error)
    }

}