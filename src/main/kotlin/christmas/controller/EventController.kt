package christmas.controller

import christmas.user.Cashier
import christmas.user.Date
import christmas.user.MyOrders
import christmas.io.UserInterface
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EventController(private val ui: UserInterface = UserInterface()) {

    fun go() {
        ui.printIntroMsg()

        val date = makeDate()
        val myOrders = makeOrders()
        val eventProvider = EventProvider(myOrders, date)

        showDayOrders(date, myOrders)
        printInitTotalPrice(myOrders)

        applyEvents(eventProvider)
    }

    private fun getDayOfWeek(day: Int): String {
        val visitDate = "2023-12-$day"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
        val date = LocalDate.parse(visitDate, formatter)

        return date.dayOfWeek.toString()

    }

    private fun makeDate(): Date {
        val visitDate = ui.askDate()
        val dayOfWeek = getDayOfWeek(visitDate)
        return Date(visitDate, dayOfWeek)
    }

    private fun makeOrders(): MyOrders {
        val cashier = Cashier()
        val menus = cashier.readMenus()
        return cashier.makeOrders(menus)
    }

    private fun showDayOrders(date: Date, myOrders: MyOrders) {
        date.printVisitDateService()
        myOrders.printMyOrders()
    }

    private fun printInitTotalPrice(myOrders: MyOrders) {
        val initTotalPrice = myOrders.getInitTotalPrice()
        myOrders.printInitTotalPrice(initTotalPrice)
    }

    private fun applyEvents(eventProvider: EventProvider) {
        eventProvider.applyEvents()

        eventProvider.printGiftEvent()
        eventProvider.printMyBenefits()
        eventProvider.printMyTotalBenefitAmount()
        eventProvider.printMyFinalPrice()
        eventProvider.printEventBadge()
    }

}