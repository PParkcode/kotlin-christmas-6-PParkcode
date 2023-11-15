package christmas

import christmas.io.UserInterface

class Date(private val day: Int, private val dayOfWeek:String) {

    fun getChristmasSale(): Int {
        if (day > 25) {
            return 0
        }
        return 1000 + ((day - 1) * 100)
    }

    fun printVisitDateService() {
        val ui = UserInterface()
        ui.printVisitDateService(day)
    }

    fun isWeekend():Boolean {
        return dayOfWeek == "FRIDAY" || dayOfWeek== "SATURDAY"
    }
    fun isSpecialSaleDay():Boolean {
        return dayOfWeek == "SUNDAY" || day == 25
    }

}
