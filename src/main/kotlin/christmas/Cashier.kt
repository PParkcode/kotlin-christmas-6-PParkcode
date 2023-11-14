package christmas

import christmas.io.UserInterface

class Cashier {

    fun readMenus():List<Pair<String,Int>> {
        val ui = UserInterface()
        val menus = ui.askMenus()
        return menus
    }

    fun makeOrders(menus: List<Pair<String, Int>>):MyOrders {
        val myMenus = mutableListOf<Menu>()

        for (menu in menus) {
            val name = menu.first
            val count = menu.second
            val course = Course.findCourse(name)
            myMenus.add(Menu(name, course.getPrice(name), count, course, course.getPrice(name)))
        }
        return MyOrders(myMenus)
    }

}