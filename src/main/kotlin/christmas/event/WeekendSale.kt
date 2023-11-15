package christmas.event

import christmas.io.UserInterface

class WeekendSale(private val amount: Int): ISaleEvent {

    override fun printMySale() {
        val ui = UserInterface()
        ui.printBenefit("주말 할인", amount)
    }
}