package com.bartoszkrol.catfacts.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * Builds retrofit dependencies.
 */

fun buildClient(): OkHttpClient =
    OkHttpClient.Builder()
        .build()

fun buildRetrofit(baseUrl: String): Retrofit {
    val contentType = "application/json".toMediaType()

    return Retrofit.Builder()
        .client(buildClient())
        .baseUrl(baseUrl)
        .addConverterFactory(Json.nonstrict.asConverterFactory(contentType))
        .build()
}

fun buildApiService(baseUrl: String): RemoteApiService = buildRetrofit(baseUrl).create(RemoteApiService::class.java)