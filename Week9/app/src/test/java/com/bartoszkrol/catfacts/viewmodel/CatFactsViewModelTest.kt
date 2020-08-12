package com.bartoszkrol.catfacts.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bartoszkrol.catfacts.database.CatFactsDatabase
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.model.CatFact
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CatFactsViewModelTest {

    private lateinit var catFactsViewModel: CatFactsViewModel

    private val testDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope = TestCoroutineScope(testDispatcher)

    private val catFacts = mutableListOf<CatFact>(
        CatFact("1","this is first fact about the cats", null, 1),
        CatFact("2","this is second fact about the cats", null, 4),
        CatFact("3","this is third fact about the cats", null, 3)
    )

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: RoomRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        // cant test it with database because i have no access to context
//        repository = CatFactsDatabase.getDatabase(this).catFactsDao()
        catFactsViewModel = CatFactsViewModel(repository)


        // insert default CatFacts
        testCoroutineScope.runBlockingTest {
            catFactsViewModel.insertCatFacts(catFacts)
        }
    }

    @Test
    fun getCatFacts() =
        testCoroutineScope.runBlockingTest {
            val liveData = catFactsViewModel.getCatFacts()

            assertEquals(3, liveData.value?.size)
        }

    @Test
    fun removeCatFacts() =
        testCoroutineScope.runBlockingTest {
            // remove first CatFact from CatFacts
            catFacts.removeAt(0)
            val liveData = catFactsViewModel.getCatFacts()

            assertEquals(2, liveData.value?.size)
        }

    @Test
    fun insertCatFacts() =
        testCoroutineScope.runBlockingTest {
            catFacts.add(CatFact("4","Another fact about the cats!", null, 5))
            val liveData = catFactsViewModel.getCatFacts()

            assertEquals(3, liveData.value?.size)
        }

}