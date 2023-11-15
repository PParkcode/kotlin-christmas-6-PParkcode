package christmas.event

import christmas.io.UserInterface

class GiftEvent(private val amount: Int): ISaleEvent {

    override fun printMySale() {
        val ui = UserInterface()
        ui.printBenefit("증정 이벤트", amount)
    }

    override fun getAmount():Int {
        return amount
    }
}