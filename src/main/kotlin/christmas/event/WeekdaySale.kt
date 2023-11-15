package christmas.event

import christmas.io.UserInterface

class WeekdaySale(private val amount: Int): ISaleEvent{

    override fun printMySale() {
        val ui = UserInterface()
        ui.printBenefit("평일 할인", amount)
    }

    override fun getAmount():Int {
        return amount
    }
}