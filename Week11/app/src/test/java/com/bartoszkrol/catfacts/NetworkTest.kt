package com.bartoszkrol.catfacts

import android.content.Context
import com.bartoszkrol.catfacts.di.networkModule
import com.bartoszkrol.catfacts.model.Success
import com.bartoszkrol.catfacts.networking.NetworkStatusChecker
import com.bartoszkrol.catfacts.networking.RemoteApi
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import org.mockito.Mockito.mock

/**
 * This test checks the network module
 */
class NetworkTest : KoinTest {

    // Context is required for repository and network modules
    private val context = mock(Context::class.java)
    private val baseUrl: String by lazy { get(named("BASE_URL")) as String }
    private val remoteApi: RemoteApi by inject()
    private val networkStatusChecker: NetworkStatusChecker by inject()

    @Before
    fun setup() {
        startKoin {
            androidContext(context)
            modules(networkModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Test base URL`() {
        assert(baseUrl == "https://cat-fact.herokuapp.com")
    }

    @Test
    fun `Test API Created`() {
        assertNotNull(remoteApi)
    }

    @Test
    fun `Test Network Status Checker Created`() {
        assertNotNull(networkStatusChecker)
    }

    @Test
    fun `Test Downloading the Cat Facts`() = runBlocking {
        val result = remoteApi.getCatFacts()

        if (result is Success) {
            assert(true)
        } else {
            assert(false)
        }
    }

}