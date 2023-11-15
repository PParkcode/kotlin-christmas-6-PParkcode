package christmas.io

import christmas.Menu

class UserInterface(
    private val output: OutputView = OutputView(),
    private val input: InputView = InputView()
) {
    fun printIntroMsg() {
        output.printIntroMsg()
    }

    fun askDate(): Int {
        var date: Int
        while (true) {
            try {
                date = input.readDate()
                return date
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun askMenus(): List<Pair<String, Int>> {
        var menus: List<Pair<String, Int>>
        while (true) {
            try {
                menus = input.readMenu()
                return menus
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun printInitPrice(initTotalPrice: Int) {
        output.printInitTotalPrice(initTotalPrice)
    }

    fun printVisitDateService(day: Int) {
        output.printVisitDateService(day)
    }

    fun printMyOrders(menus: List<Menu>) {
        output.printMyOrders(menus)
    }
    fun printGiftEventIntroMsg() {
        output.printGiftEventIntroMsg()
    }
    fun printGiftEvent(gift:String, count:Int) {
        output.printGift(gift, count)
    }
    fun printBenefitIntroMsg() {
        output.printBenefitIntroMsg()
    }

    fun printBenefit(eventName:String, saleAmount:Int) {
        output.printBenefit(eventName, saleAmount)
    }

    fun printTotalBenefitAmountIntroMsg() {
        output.printTotalBenefitAmountIntroMsg()
    }
    fun printTotalBenefitAmount(amount:Int) {
        output.printTotalBenefitAmount(amount)
    }

    fun printFinalPrice(price:Int) {
        output.printFinalPriceIntroMsg()
        output.printFinalPrice(price)
    }

    fun printEventBadge(type:String) {
        output.printEventBadgeIntroMsg()
        output.printEventBadge(type)
    }

    fun printNothing() {
        output.printNothing()
    }
}