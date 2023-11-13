package christmas.io

import camp.nextstep.edu.missionutils.Console
import christmas.Menu
import christmas.exception.ExceptionChecker

class InputView(private val checker: ExceptionChecker = ExceptionChecker()) {

    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val date = Console.readLine()
        checker.checkDate(date)
        return date.toInt()
    }

    fun readMenu(): List<Pair<String, Int>> {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")

        val orders = mutableListOf<Pair<String, Int>>()
        val menus = Console.readLine().split(",")
        for(menu in menus) {
            orders.add(checker.checkMenus(menu))
        }
        checker.checkOrders(orders)
        return orders
    }

}
