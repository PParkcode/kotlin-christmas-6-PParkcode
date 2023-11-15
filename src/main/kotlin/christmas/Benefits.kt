package christmas

import christmas.event.*
import christmas.io.UserInterface


class Benefits(
    private val myBenefits:MutableList<ISaleEvent>
) {


    fun addMyBenefit(event:ISaleEvent) {
        myBenefits.add(event)
    }

    fun isGiftEvent(): Boolean {
        for(benefit in myBenefits) {
            if(benefit is GiftEvent ) {
                return true
            }
        }
        return false
    }
    fun printMyBenefits() {
        val ui = UserInterface()

        ui.printBenefitIntroMsg()
        if(myBenefits.isEmpty()) {
            ui.printNothing()
            return
        }
        for(benefit in myBenefits) {
            benefit.printMySale()
        }
    }

    fun printTotalBenefitAmount() {
        val ui = UserInterface()

        ui.printTotalBenefitAmountIntroMsg()
        ui.printTotalBenefitAmount(getTotalBenefitAmount())
    }

    fun getTotalBenefitAmount():Int {
        var totalBenefitAmount = 0
        for(benefit in myBenefits) {
            totalBenefitAmount += benefit.getAmount()
        }
        return totalBenefitAmount
    }

    fun getTotalDiscount(): Int {
        var totalBenefitDiscount = 0
        for(benefit in myBenefits) {
            if(benefit is GiftEvent) {
                continue
            }
            totalBenefitDiscount += benefit.getAmount()
        }
        return totalBenefitDiscount
    }
}