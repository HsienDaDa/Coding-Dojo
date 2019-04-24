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
    fun `Test getGameName() return "Potter" `() {
        val name = potter.getGameName()

        Assert.assertEquals("Potter", name)
    }

    @Test
    fun `Test getBooksPrice() if one book price return 100`() {
        val bookList: List<Int> = listOf(1)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(100, price)
    }

    @Test
    fun `Test getBooksPrice() if two continuous book price return 195`() {
        val bookList: List<Int> = listOf(1, 2)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(195, price)
    }

    @Test
    fun `Test getBooksPrice when two books duplicate then return 200 `() {
        val bookList: List<Int> = listOf(1, 1)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(200, price)
    }
}