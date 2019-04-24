package com.supermumu.codingdojo.katagame

class PotterKata {
    
    private val bookPrice = 100
    
    fun getGameName(): String {
        return "Potter"
    }

    fun getBooksPrice(bookList: List<Int>): Int {
        return when {
            bookList.isEmpty() -> 0
            bookList.size == 1 -> bookPrice
            else -> {
                val sortedList = bookList.sorted()
                var discount = 100
                var totalPrice = bookPrice
                sortedList.forEachIndexed { index, vol ->
                    val price = bookPrice
                    if (index == 0) {
                        return@forEachIndexed
                    }
                    val prevVol = sortedList[index - 1]
                    discount = if (vol - prevVol == 1) {
                        discount - 5
                    } else {
                        100
                    }
                    totalPrice += (price * discount) / 100
                }
                return totalPrice
            }
        }
    }
}