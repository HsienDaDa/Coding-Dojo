package com.supermumu.codingdojo.katagame

class PotterKata {

    companion object {
        private const val BOOK_PRICE = 100
        private const val DEFAULT_DISCOUNT = 100
        private const val DISCOUNT_STEP = 5
    }

    fun getGameName(): String {
        return "Potter"
    }

    fun getBooksPrice2(bookList: List<Int>, defDiscount: Int = DEFAULT_DISCOUNT, defStep: Int = DISCOUNT_STEP): Int {
        return when {
            bookList.isEmpty() -> 0
            bookList.size == 1 -> BOOK_PRICE
            else -> {
                val sortedList = bookList.sorted()
                var discount = 100
                var totalPrice = BOOK_PRICE

                sortedList.forEachIndexed { index, vol ->
                    val price = PotterKata.BOOK_PRICE
                    if (index == 0) return@forEachIndexed

                    val prevVol = sortedList[index - 1]
                    val volDiscount = when {
                        vol == prevVol -> defDiscount
                        vol - prevVol == 1 -> {
                            discount -= defStep
                            discount
                        }
                        else -> {
                            discount = defDiscount
                            discount
                        }
                    }
                    totalPrice += (price * volDiscount) / 100
                }
                return totalPrice
            }
        }
    }

    fun getBooksPrice(bookList: List<Int>, defDiscount: Int = PotterKata.DEFAULT_DISCOUNT, defStep: Int = PotterKata.DISCOUNT_STEP): Int {
        return when {
            bookList.isEmpty() -> 0
            bookList.size == 1 -> PotterKata.BOOK_PRICE
            else -> {
                val sortedList = bookList.sorted()
                var discount = defDiscount

                var totalDiscount = 100
                sortedList.forEachIndexed { index, vol ->
                    if (index == 0) return@forEachIndexed

                    val prevVol = sortedList[index - 1]
                    val volDiscount = when {
                        vol - prevVol == 1 -> {
                            discount -= defStep
                            discount
                        }
                        vol == prevVol -> defDiscount
                        else -> {
                            discount = defDiscount
                            defDiscount
                        }
                    }
                    totalDiscount += volDiscount
                }

                return PotterKata.BOOK_PRICE * totalDiscount / 100
            }
        }
    }
}
//
//fun getBooksPrice(bookList: List<Int>, defDiscount: Int = PotterKata.DEFAULT_DISCOUNT, defStep: Int = PotterKata.DISCOUNT_STEP): Int {
//    return when {
//        bookList.isEmpty() -> 0
//        bookList.size == 1 -> PotterKata.BOOK_PRICE
//        else -> {
//            val sortedList = bookList.sorted()
//            var discount = defDiscount
//            var totalPrice = PotterKata.BOOK_PRICE
//
//            sortedList.forEachIndexed { index, vol ->
//                val price = PotterKata.BOOK_PRICE
//                if (index == 0) return@forEachIndexed
//
//                val prevVol = sortedList[index - 1]
//                discount = if (vol - prevVol == 1) {
//                    discount - defStep
//                } else {
//                    defDiscount
//                }
//                totalPrice += (price * discount) / 100
//            }
//            return totalPrice
//        }
//    }
//}
