package christmas

import christmas.io.UserInterface

class EventProvider(private val myOrders: MyOrders, private val date: Date) {

    fun applyEvents() {
        if(myOrders.getInitTotalPrice()>=10000) {
            applyChristmasSale()
            applyWeekSale()
            applySpecialSale()
            applyGiftEvent()
        }
    }

    fun printGiftEvent() {
        val ui =UserInterface()
        ui.printGiftEventIntroMsg()
        if(myOrders.isContainGiftEvent()) {
            ui.printGiftEvent("샴페인", 1)
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

    private fun applyChristmasSale() {
        val christmasSale = date.getChristmasSale()
        if(christmasSale>0) {
            myOrders.applyChristmasEvent(christmasSale)
        }
    }

    private fun applyWeekSale() {
        if(date.isWeekend()) {
            applyWeekendSale()
            return
        }
        applyWeekDaySale()
    }
    private fun applySpecialSale() {
        if(date.isSpecialSaleDay()) {
            myOrders.applySpecialEvent(1000)
        }
    }

    private fun applyGiftEvent() {
        if (myOrders.getInitTotalPrice() >= 120000) {
            myOrders.applyGiftEvent(Course.Drink.getPrice("샴페인"))

        }
    }

    private fun applyWeekDaySale() {
        val numOfDessert = myOrders.countDessert()
        val weekdaySale = 2023 * numOfDessert
        if(weekdaySale>0) {
            myOrders.applyWeekdayEvent(weekdaySale)
        }

    }

    private fun applyWeekendSale() {
        val numOfMainCourse = myOrders.countMainCourse()
        val weekendSale = 2023 * numOfMainCourse
        myOrders.applyWeekendEvent(weekendSale)
    }
}