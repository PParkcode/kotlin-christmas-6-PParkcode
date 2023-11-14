package christmas

import christmas.io.UserInterface

class Cashier {

    fun readMenus() {
        val ui = UserInterface()
        val menus = ui.askMenus()
    }

    fun makeOrders(menus: List<Pair<String, Int>>) {
        val myMenus = mutableListOf<Menu>()

        for (menu in menus) {
            val name = menu.first
            val count = menu.second
            val course = Course.findCourse(name)
            myMenus.add(Menu(name, course.getPrice(name), count, course, course.getPrice(name)))
        }
    }

}