package christmas

import christmas.io.UserInterface

class Cashier {

    fun readMenus() {
        val ui = UserInterface()
        val menus = ui.askMenus()
    }

}