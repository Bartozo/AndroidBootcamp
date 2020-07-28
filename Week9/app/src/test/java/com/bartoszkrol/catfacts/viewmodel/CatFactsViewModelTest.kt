package com.bartoszkrol.catfacts.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bartoszkrol.catfacts.database.RoomRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CatFactsViewModelTest {

    private lateinit var catFactsViewModel: CatFactsViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: RoomRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        catFactsViewModel = CatFactsViewModel(repository)
    }

    @Test
    fun getCatFacts() {

    }

    @Test
    fun removeCatFacts() {

    }

    @Test
    fun insertCatFacts() {

    }

}