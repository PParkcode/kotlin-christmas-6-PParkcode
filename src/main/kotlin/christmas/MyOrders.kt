package christmas

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

    fun printInitTotalPrice(initPrice:Int) {
        val ui = UserInterface()
        ui.printInitPrice(initPrice)
    }

    fun printMyOrders() {
        val ui = UserInterface()
        ui.printMyOrders(menus)
    }

    fun countDessert():Int {
        var count = 0
        for(menu in menus) {
            count+=menu.isEqualCourse("Dessert")
        }
        return count
    }

    fun countMainCourse():Int {
        var count = 0
        for(menu in menus) {
            count+=menu.isEqualCourse("MainCourse")
        }
        return count
     }

    fun applyGiftEvent(amount: Int) {
        benefits.addMyBenefit(GiftEvent(amount))
    }

    fun applyChristmasEvent(amount: Int) {
        benefits.addMyBenefit(ChristmasSale(amount))
    }

    fun applyWeekendEvent(amount:Int) {
        benefits.addMyBenefit(WeekendSale(amount))
    }

    fun applyWeekdayEvent(amount:Int) {
        benefits.addMyBenefit(WeekdaySale(amount))
    }

    fun applySpecialEvent(amount: Int) {
        benefits.addMyBenefit(SpecialSale(amount))
    }

    fun printMyBenefits() {
        benefits.printMyBenefits()
    }
    fun printTotalBenefitAmount() {
        benefits.printTotalBenefitAmount()
    }

    fun isContainGiftEvent():Boolean {
        return benefits.isGiftEvent()
    }

    fun getTotalBenefitAmount():Int {
        return benefits.getTotalBenefitAmount()
    }
}