package christmas.user

import christmas.event.*
import christmas.io.UserInterface

class MyOrders(private val menus: List<Menu>, private val benefits: Benefits) {

    fun getInitTotalPrice(): Int {
        var totalPrice = 0
        for (menu in menus) {
            totalPrice += menu.getInitTotalPrice()
        }
        return totalPrice
    }

    fun printInitTotalPrice(initPrice: Int) {
        val ui = UserInterface()
        ui.printInitPrice(initPrice)
    }

    fun printMyOrders() {
        val ui = UserInterface()
        ui.printMyOrders(menus)
    }

    fun countDessert(): Int {
        var count = 0
        for (menu in menus) {
            count += menu.isEqualCourse("DESSERT")
        }
        return count
    }

    fun countMainCourse(): Int {
        var count = 0
        for (menu in menus) {
            count += menu.isEqualCourse("MAIN_COURSE")
        }
        return count
    }

    fun applyGiftEvent(amount: Int) {
        benefits.addMyBenefit(GiftEvent(GIFT_EVENT, amount))
    }

    fun applyChristmasEvent(amount: Int) {
        benefits.addMyBenefit(ChristmasSale(CHRISTMAS_EVENT, amount))
    }

    fun applyWeekendEvent(amount: Int) {
        benefits.addMyBenefit(WeekendSale(WEEKEND_EVENT, amount))
    }

    fun applyWeekdayEvent(amount: Int) {
        benefits.addMyBenefit(WeekdaySale(WEEKDAY_EVENT, amount))
    }

    fun applySpecialEvent(amount: Int) {
        benefits.addMyBenefit(SpecialSale(SPECIAL_EVENT, amount))
    }

    fun printMyBenefits() {
        benefits.printMyBenefits()
    }

    fun printTotalBenefitAmount() {
        benefits.printTotalBenefitAmount()
    }

    fun isContainGiftEvent(): Boolean {
        return benefits.isGiftEvent()
    }

    fun getTotalBenefitAmount(): Int {
        return benefits.getTotalBenefitAmount()
    }

    fun getTotalDiscountAmount(): Int {
        return benefits.getTotalDiscount()
    }

    companion object {
        const val CHRISTMAS_EVENT = "크리스마스 디데이 할인"
        const val WEEKDAY_EVENT = "평일 할인"
        const val WEEKEND_EVENT = "주말 할인"
        const val SPECIAL_EVENT = "특별 할인"
        const val GIFT_EVENT = "증정 이벤트"
    }
}