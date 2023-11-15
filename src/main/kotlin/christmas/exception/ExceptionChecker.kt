package christmas.exception

import christmas.data.Course

class ExceptionChecker {

    fun checkDate(date: String) {
        isDigit(date, INVALID_DATE_ERROR)
        isInRange(date.toInt())
    }

    private fun isDigit(number: String, errorMsg: String) {
        if (number == NO_INPUT) {
            throw IllegalArgumentException(errorMsg)
        }
        for (digit in number) {
            if (!digit.isDigit()) {
                throw IllegalArgumentException(errorMsg)
            }
        }
    }

    private fun isInRange(date: Int) {
        if (DAY_MIN_LIMIT > date || date > DAY_MAX_LIMIT) {
            throw IllegalArgumentException(INVALID_DATE_ERROR)
        }
    }

    fun checkMenus(order: String): Pair<String, Int> {
        if (!checkSlash(order)) {
            throw IllegalArgumentException(INVALID_ORDER_ERROR)
        }
        val (name, count) = order.split("-")

        if (!isValidMenu(name)) {
            throw IllegalArgumentException(INVALID_ORDER_ERROR)
        }
        isDigit(count, INVALID_ORDER_ERROR)
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
            throw IllegalArgumentException(INVALID_ORDER_ERROR)
        }
    }

    fun checkOrders(orders: List<Pair<String, Int>>) {
        countTotalMenus(orders)
        isDuplicated(orders)
        isOnlyDrink(orders)
    }

    private fun countTotalMenus(orders: List<Pair<String, Int>>) {
        var total = 0
        for (order in orders) {
            total += order.second
        }
        if (total > MENU_MAX_LIMIT) {
            throw IllegalArgumentException(INVALID_ORDER_ERROR)
        }
    }

    private fun isDuplicated(orders: List<Pair<String, Int>>) {
        val items = mutableListOf<String>()
        for (order in orders) {
            if (items.contains(order.first)) {
                throw IllegalArgumentException(INVALID_ORDER_ERROR)
            }
            items.add(order.first)
        }
    }

    private fun isOnlyDrink(orders: List<Pair<String, Int>>) {
        for (order in orders) {
            if (!Course.DRINK.isContain(order.first)) {
                return
            }
        }
        throw IllegalArgumentException(INVALID_ORDER_ERROR)
    }

    companion object {
        const val INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        const val INVALID_DATE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
        const val NO_INPUT = ""
        const val DAY_MIN_LIMIT = 1
        const val DAY_MAX_LIMIT = 31
        const val MENU_MAX_LIMIT = 20
    }
}