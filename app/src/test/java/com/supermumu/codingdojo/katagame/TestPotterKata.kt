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

    @Test
    fun `Test getBooksPrice when two books 不連續 then return 200 `() {
        val bookList: List<Int> = listOf(1, 3)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(200, price)
    }

    @Test
    fun `Test getBooksPrice when three books 兩本連續 1本不連續 then return 295 `() {
        val bookList: List<Int> = listOf(1, 2, 4)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(295, price)
    }

    @Test
    fun `Test getBooksPrice when all books then return 660 `() {
        val bookList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(660, price)
    }

    @Test
    fun `Test getBooksPrice when two same books and one continuous then return 295 `() {
        val bookList: List<Int> = listOf(1, 1, 2)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(295, price)
    }

    @Test
    fun `Test getBooksPrice when 0 book then return 0 `() {
        val bookList: List<Int> = listOf()
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(0, price)
    }

    @Test
    fun `Test getBooksPrice sorted`() {
        val bookList: List<Int> = listOf(1, 8, 2)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(295, price)
    }

    @Test
    fun `Test getBooksPrice 連續兩本連續 中間不連續`() {
        val bookList: List<Int> = listOf(1, 2, 4, 6, 7)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(490, price)
    }

    @Test
    fun `Test getBooksPrice `() {
        val bookList: List<Int> = listOf(1, 2, 3, 1, 2, 3)
        val price = potter.getBooksPrice(bookList)

        Assert.assertEquals(585, price)
    }

}