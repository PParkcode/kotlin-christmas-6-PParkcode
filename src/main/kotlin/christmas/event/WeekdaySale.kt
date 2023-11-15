package christmas.event

import christmas.io.UserInterface

class WeekdaySale(private val eventName: String, private val amount: Int) : ISaleEvent {

    override fun printMySale() {
        val ui = UserInterface()
        ui.printBenefit(eventName, amount)
    }

    override fun getAmount(): Int {
        return amount
    }
}