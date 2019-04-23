package com.supermumu.codingdojo.katagame

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestPotterKata {

    private lateinit var potter: PotterKata

    @Before
    fun setUp() {
        potter = PotterKata()
    }

    @Test
    fun `Test getGameName()`() {
        val name = potter.getGameName()

        Assert.assertEquals("Potter", name)
    }
}