package christmas

import christmas.io.UserInterface
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

}
