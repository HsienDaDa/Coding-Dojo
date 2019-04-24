package com.supermumu.codingdojo.katagame

class PotterKata {
    fun getGameName(): String {
        return "Potter"
    }

    fun getBooksPrice(bookList: List<Int>): Int {
        return if (bookList.size == 1) {
            100
        } else {
            0
        }
    }
}