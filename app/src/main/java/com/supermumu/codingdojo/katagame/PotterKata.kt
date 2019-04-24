package com.supermumu.codingdojo.katagame

class PotterKata {
    fun getGameName(): String {
        return "Potter"
    }

    fun getBooksPrice(bookList: List<Int>): Int {
        return when {
            bookList.isEmpty() -> 0
            bookList.size == 1 -> 100
            else -> {
                val sortedList = bookList.sorted()
                var discount = 1F
                var price = 100
                sortedList.forEachIndexed { index, vol ->
                    if (index == 0) {
                        return@forEachIndexed
                    }
                    val prevVol = sortedList[index - 1]
                    if (vol - prevVol == 1) {
                        discount = 1F - 0.05F
                    }
                    price += (price * discount).toInt()
                }
                return price
            }
        }
    }
}