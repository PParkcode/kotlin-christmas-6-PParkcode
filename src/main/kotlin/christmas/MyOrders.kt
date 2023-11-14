package christmas

import christmas.io.UserInterface

class MyOrders(private val menus: List<Menu>) {

    fun getInitTotalPrice(): Int {
        var totalPrice = 0
        for (menu in menus) {
            totalPrice += menu.getPrice()
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
}