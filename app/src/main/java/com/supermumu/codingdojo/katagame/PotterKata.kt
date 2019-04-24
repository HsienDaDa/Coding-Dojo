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
                var discount: Float
                var totalPrice = bookPrice
                sortedList.forEachIndexed { index, vol ->
                    val price = bookPrice
                    if (index == 0) {
                        return@forEachIndexed
                    }
                    val prevVol = sortedList[index - 1]
                    discount = if (vol - prevVol == 1) {
                        1F - 0.05F
                    } else {
                        1F
                    }
                    totalPrice += (price * discount).toInt()
                }
                return totalPrice
            }
        }
    }
}