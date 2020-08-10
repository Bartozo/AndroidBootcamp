package com.bartoszkrol.catfacts

import android.content.Context
import com.bartoszkrol.catfacts.di.networkModule
import com.bartoszkrol.catfacts.di.repositoryModule
import com.bartoszkrol.catfacts.di.viewModelModule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.mockito.Mockito.mock

/**
 * Checks modules for DI
 */
class ModuleCheckTest : KoinTest {

    // Context is required for repository and network modules
    private val context = mock(Context::class.java)

    @Test
    fun `Test Repository Module`() {
        startKoin {
            androidContext(context)
            modules(repositoryModule)
        }.checkModules()

        stopKoin()
    }

    @Test
    fun `Test Network Module`() {
        startKoin {
            androidContext(context)
            modules(networkModule)
        }.checkModules()

        stopKoin()
    }

    @Test
    fun `Test ViewModel Module`() {
        startKoin {
            modules(viewModelModule)
        }.checkModules()

        stopKoin()
    }

}