package christmas.io

import christmas.user.Menu

class OutputView {

    fun printIntroMsg() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printMyOrders(menus: List<Menu>) {
        println("<주문 메뉴>")
        for (menu in menus) {
            println("${menu.getName()} ${menu.getCount()}개")
        }
        println()
    }

    fun printInitTotalPrice(initTotalPrice: Int) {
        val formattedTotalPrice = String.format("%,d", initTotalPrice)
        println("<할인 전 총주문 금액>")
        println("${formattedTotalPrice}원")
        println()
    }

    fun printVisitDateService(day: Int) {
        println("12월 ${day}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()
    }

    fun printGiftEventIntroMsg() {
        println("<증정 메뉴>")
    }

    fun printGift(gift: String, count: Int) {
        println("$gift ${count}개")
        println()
    }

    fun printBenefitIntroMsg() {
        println("<혜택 내역>")
    }

    fun printBenefit(eventName: String, saleAmount: Int) {
        val formattedAmount = String.format("%,d", saleAmount)
        println("${eventName}: -${formattedAmount}원")
    }

    fun printTotalBenefitAmountIntroMsg() {
        println()
        println("<총혜택 금액>")
    }

    fun printTotalBenefitAmount(amount: Int) {
        val formattedAmount = String.format("%,d", amount)
        println("-${formattedAmount}원")
        println()
    }

    fun printFinalPriceIntroMsg() {
        println("<할인 후 예상 결제 금액>")
    }

    fun printFinalPrice(price: Int) {
        val formattedPrice = String.format("%,d", price)
        println("${formattedPrice}원")
        println()
    }

    fun printEventBadgeIntroMsg() {
        println("<12월 이벤트 배지>")
    }

    fun printEventBadge(type: String) {
        println(type)
        println()
    }

    fun printNothing() {
        println("없음")
        println()
    }
}