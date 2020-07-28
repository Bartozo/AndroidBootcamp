package com.bartoszkrol.catfacts.model

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class CatFactTest {

    private lateinit var catFact: CatFact

    @Before
    fun setUp() {
        catFact = CatFact("1","this is super interesting fact about the cats!",
            null, 1)
    }

    @Test
    fun get_id() {
        assertEquals("1", catFact._id)
    }

    @Test
    fun getText() {
        assertEquals("this is super interesting fact about the cats!", catFact.text)
    }

    @Test
    fun getUser() {
        assertEquals(null, null)
    }

    @Test
    fun getUpvotes() {
        assertEquals(1, catFact.upvotes)
    }
}