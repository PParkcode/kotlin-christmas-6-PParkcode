package christmas

import christmas.io.UserInterface
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EventController(private val ui: UserInterface = UserInterface()) {

    fun go() {
        ui.printIntroMsg()

        val visitDate = ui.askDate()
        val dayOfWeek = getDayOfWeek(visitDate)
        val date = Date(visitDate, dayOfWeek)

        val cashier = Cashier()
        val menus = cashier.readMenus()
        val myOrders  = cashier.makeOrders(menus)

        date.printVisitDateService()
        myOrders.printMyOrders()

        val initTotalPrice = myOrders.getInitTotalPrice()
        myOrders.printInitTotalPrice(initTotalPrice)
        val eventProvider = EventProvider(myOrders,date)
        eventProvider.applyEvents()
        eventProvider.printMyBenefits()


    }

    fun getDayOfWeek(day: Int): String {
        val visitDate = "2023-12-$day"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
        val date = LocalDate.parse(visitDate, formatter)

        return date.dayOfWeek.toString()

    }

    fun showEventResult() {

    }
}