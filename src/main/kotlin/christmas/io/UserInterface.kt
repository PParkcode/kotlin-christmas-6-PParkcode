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
        println("12월 ${day}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun printMyOrders(menus: List<Menu>) {
        output.printMyOrders(menus)
    }
}