package com.bartoszkrol.catfacts.networking

import com.bartoszkrol.catfacts.model.response.GetCatFactsResponse
import retrofit2.http.GET

interface RemoteApiService {

    @GET("/facts")
    suspend fun getCatFacts(): GetCatFactsResponse

}