package christmas

import christmas.event.*
import christmas.io.UserInterface


class Benefits(
    private val myBenefits:MutableList<ISaleEvent>
) {

    fun addMyBenefit(event:ISaleEvent) {
        myBenefits.add(event)
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

    fun getTotalBenefitAmount() {
        //return christmasSaleAmount + weekSaleAmount + specialSaleAmount + gift
    }

    fun getTotalDiscount() {
        //return christmasSaleAmount + weekSaleAmount + specialSaleAmount
    }
}