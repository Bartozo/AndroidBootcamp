package com.bartoszkrol.catfacts.networking

import retrofit2.http.GET

interface RemoteApiService {

    @GET("/facts")
    suspend fun getCatFacts()

}