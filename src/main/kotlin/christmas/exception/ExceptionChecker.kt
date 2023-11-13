package christmas.exception

import christmas.Course

class ExceptionChecker {

    fun checkDate(date: String) {
        isDigit(date, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        isInRange(date.toInt())
    }

    private fun isDigit(number: String, errorMsg: String) {
        if (number == "") {
            throw IllegalArgumentException(errorMsg)
        }
        for (digit in number) {
            if (!digit.isDigit()) {
                throw IllegalArgumentException(errorMsg)
            }
        }
    }

    private fun isInRange(date: Int) {
        if (1 > date || date > 31) {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    fun checkMenus(order: String): Pair<String, Int> {
        if (!checkSlash(order)) {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
        val (name, count) = order.split("-")

        if (!isValidMenu(name)) {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
        isDigit(count, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        isNotZero(count.toInt())
        return Pair(name, count.toInt())
    }

    private fun isValidMenu(name: String): Boolean {
        for (course in Course.values()) {
            if (course.isContain(name)) {
                return true
            }
        }
        return false
    }

    private fun checkSlash(order: String): Boolean {
        var count = 0
        for (character in order) {
            if (character == '-') {
                count++
            }
        }
        return count == 1
    }

    private fun isNotZero(count: Int) {
        if (count < 1) {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }

    fun checkOrders(orders: List<Pair<String,Int>>) {
        countTotalMenus(orders)
        isDuplicated(orders)
        isOnlyDrink(orders)
    }
    private fun countTotalMenus(orders: List<Pair<String,Int>>) {
        var total = 0
        for(order in orders) {
            total+=order.second
        }
        println(total)
        if(total>20) {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }
    private fun isDuplicated(orders:List<Pair<String,Int>>) {
        val items = mutableListOf<String>()
        for(order in orders) {
            if(items.contains(order.first)) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            }
            items.add(order.first)
        }
    }

    private fun isOnlyDrink(orders: List<Pair<String, Int>>) {
        for(order in orders) {
            if(!Course.Drink.isContain(order.first)) {
                return
            }
        }
        throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }
}