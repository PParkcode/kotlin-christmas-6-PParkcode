package christmas.event

import christmas.io.UserInterface

class SpecialSale(private val amount: Int): ISaleEvent {

    override fun printMySale() {
        val ui = UserInterface()
        ui.printBenefit("특별 할인", amount)
    }
}