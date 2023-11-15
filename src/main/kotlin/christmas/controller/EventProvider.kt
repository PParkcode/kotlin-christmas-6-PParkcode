package christmas.controller

import christmas.data.Course
import christmas.user.Date
import christmas.data.EventBadge
import christmas.user.MyOrders
import christmas.io.UserInterface

class EventProvider(private val myOrders: MyOrders, private val date: Date) {

    fun applyEvents() {
        if (myOrders.getInitTotalPrice() >= EVENT_LIMIT) {
            applyChristmasSale()
            applyWeekSale()
            applySpecialSale()
            applyGiftEvent()
        }
    }

    fun printGiftEvent() {
        val ui = UserInterface()
        ui.printGiftEventIntroMsg()
        if (myOrders.isContainGiftEvent()) {
            ui.printGiftEvent(CHAMPAGNE, 1)
            return
        }

        ui.printNothing()
    }

    fun printMyBenefits() {
        myOrders.printMyBenefits()
    }

    fun printMyTotalBenefitAmount() {
        myOrders.printTotalBenefitAmount()
    }

    fun printMyFinalPrice() {
        val initPrice = myOrders.getInitTotalPrice()
        val finalPrice = initPrice - myOrders.getTotalDiscountAmount()
        val ui = UserInterface()
        ui.printFinalPrice(finalPrice)
    }

    fun printEventBadge() {
        val totalBefit = myOrders.getTotalBenefitAmount()
        val ui = UserInterface()
        if (totalBefit > SANTA_LIMIT) {
            ui.printEventBadge(EventBadge.SANTA.getType())
            return
        }
        if (totalBefit > TREE_LIMIT) {
            ui.printEventBadge(EventBadge.TREE.getType())
            return
        }
        if (totalBefit > STAR_LIMIT) {
            ui.printEventBadge(EventBadge.STAR.getType())
            return
        }
        ui.printEventBadge(EventBadge.NOTHING.getType())
    }

    private fun applyChristmasSale() {
        val christmasSale = date.getChristmasSale()
        if (christmasSale > 0) {
            myOrders.applyChristmasEvent(christmasSale)
        }
    }

    private fun applyWeekSale() {
        if (date.isWeekend()) {
            applyWeekendSale()
            return
        }
        applyWeekDaySale()
    }

    private fun applySpecialSale() {
        if (date.isSpecialSaleDay()) {
            myOrders.applySpecialEvent(SPECIAL_SALE)
        }
    }

    private fun applyGiftEvent() {
        if (myOrders.getInitTotalPrice() >= GIFT_LIMIT) {
            myOrders.applyGiftEvent(Course.DRINK.getPrice(CHAMPAGNE))

        }
    }

    private fun applyWeekDaySale() {
        val numOfDessert = myOrders.countDessert()
        val weekdaySale = WEEK_SALE * numOfDessert
        if (weekdaySale > 0) {
            myOrders.applyWeekdayEvent(weekdaySale)
        }

    }

    private fun applyWeekendSale() {
        val numOfMainCourse = myOrders.countMainCourse()
        val weekendSale = WEEK_SALE * numOfMainCourse
        myOrders.applyWeekendEvent(weekendSale)
    }

    companion object {
        const val WEEK_SALE = 2023
        const val GIFT_LIMIT = 120000
        const val SANTA_LIMIT = 20000
        const val TREE_LIMIT = 10000
        const val STAR_LIMIT = 5000
        const val EVENT_LIMIT = 10000
        const val SPECIAL_SALE = 1000
        const val CHAMPAGNE = "샴페인"
    }
}