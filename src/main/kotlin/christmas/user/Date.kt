package christmas.user

import christmas.io.UserInterface

class Date(private val day: Int, private val dayOfWeek: String) {

    fun getChristmasSale(): Int {
        if (day > CHRISTMAS_DAY) {
            return 0
        }
        return BASE_SALE + ((day - 1) * PLUS_SALE)
    }

    fun printVisitDateService() {
        val ui = UserInterface()
        ui.printVisitDateService(day)
    }

    fun isWeekend(): Boolean {
        return dayOfWeek == FRIDAY || dayOfWeek == SATURDAY
    }

    fun isSpecialSaleDay(): Boolean {
        return dayOfWeek == SUNDAY || day == CHRISTMAS_DAY
    }

    companion object {
        const val SUNDAY = "SUNDAY"
        const val FRIDAY = "FRIDAY"
        const val SATURDAY = "SATURDAY"
        const val CHRISTMAS_DAY = 25
        const val BASE_SALE = 1000
        const val PLUS_SALE = 100
    }

}
