package com.bartoszkrol.catfacts.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bartoszkrol.catfacts.database.RoomRepository
import com.bartoszkrol.catfacts.model.CatFact
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CatFactsViewModelTest {

    private lateinit var catFactsViewModel: CatFactsViewModel

    private val catFacts = mutableListOf<CatFact>(
        CatFact("1","this is first fact about the cats", null, 1),
        CatFact("2","this is second fact about the cats", null, 4),
        CatFact("3","this is third fact about the cats", null, 3)
    )

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: RoomRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        catFactsViewModel = CatFactsViewModel(repository)

        // insert 3 CatFacts
        catFactsViewModel.insertCatFacts(catFacts)
    }

    @Test
    fun getCatFacts() {
        val liveData = catFactsViewModel.getCatFacts()

        assertEquals(3, liveData.value?.size)
    }

    @Test
    fun removeCatFacts() {
        // remove first CatFact from CatFacts
        catFacts.removeAt(0)
        val liveData = catFactsViewModel.getCatFacts()

        assertEquals(2, liveData.value?.size)
    }

    @Test
    fun insertCatFacts() {
        catFacts.add(CatFact("4","Another fact about the cats!", null, 5))
        val liveData = catFactsViewModel.getCatFacts()

        assertEquals(3, liveData.value?.size)
    }

}