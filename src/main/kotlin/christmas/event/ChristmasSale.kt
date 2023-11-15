package christmas.event

import christmas.io.UserInterface

class ChristmasSale(private val amount: Int): ISaleEvent {

    override fun printMySale() {
        val ui =UserInterface()
        ui.printBenefit("크리스마스 디데이 할인", amount)
    }
}