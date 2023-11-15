package christmas.io

import christmas.Menu

class OutputView {

    fun printIntroMsg() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printDayEventIntroMsg(day: Int) {
        println("12월 ${day}y일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()
    }

    fun printMyOrders(menus: List<Menu>) {
        println("<주문 메뉴>")
        for(menu in menus) {
            println("${menu.name} ${menu.count}개")
        }
        println()
    }

    fun printInitTotalPrice(initTotalPrice: Int)  {
        println("<할인 전 총주문 금액>")
        println("${initTotalPrice}원")
        println()
    }

    fun printVisitDateService(day: Int) {
        println("12월 ${day}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()
    }

    fun printBenefitIntroMsg() {
        println("<혜택 내역>")
    }
    fun printBenefit(eventName:String, saleAmount: Int) {
        println("${eventName}: -${saleAmount}원")
    }

    fun printTotalBenefitAmountIntroMsg() {
        println()
        println("<총혜택 금액>")
    }

    fun printTotalBenefitAmount(amount:Int) {
        println("${amount}원")
    }
    fun printNothing() {
        println("없음")
    }
}