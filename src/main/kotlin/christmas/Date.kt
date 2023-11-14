package christmas

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Date(private val day: Int) {

    fun getChristmasSale(): Int {
        if (day > 25) {
            return 0
        }
        return 1000 + ((day - 1) * 100)
    }
    fun isWeekDayOrWeekend():String {
        val visitDate= "2023-12-$day" // 예시 날짜
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(visitDate, formatter)

        return date.dayOfWeek.toString()

    }
}
