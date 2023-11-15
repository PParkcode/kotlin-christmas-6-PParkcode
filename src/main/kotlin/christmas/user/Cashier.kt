package christmas.user

import christmas.data.Course
import christmas.io.UserInterface
import christmas.user.Benefits
import christmas.user.Menu
import christmas.user.MyOrders

class Cashier {

    fun readMenus(): List<Pair<String, Int>> {
        val ui = UserInterface()
        return ui.askMenus()
    }

    fun makeOrders(menus: List<Pair<String, Int>>): MyOrders {
        val myMenus = mutableListOf<Menu>()

        for (menu in menus) {
            val name = menu.first
            val count = menu.second
            val course = Course.findCourse(name)
            myMenus.add(Menu(name, course.getPrice(name), count, course))
        }
        return MyOrders(myMenus, Benefits(mutableListOf()))
    }

}