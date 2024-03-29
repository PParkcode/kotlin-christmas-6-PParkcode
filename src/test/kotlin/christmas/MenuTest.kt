package christmas

import christmas.data.Course
import christmas.event.ISaleEvent
import christmas.user.Benefits
import christmas.user.Menu
import christmas.user.MyOrders
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
class MenuTest {

    @Test
    fun `해당 메뉴가 있는지 확인`() {
        val appetizer = Course.APPETIZER
        val mainCourse = Course.MAIN_COURSE
        val dessert = Course.DESSERT
        val drink = Course.DRINK

        assertThat(appetizer.isContain("양송이수프")).isTrue()
        assertThat(mainCourse.isContain("바비큐립")).isTrue()
        assertThat(dessert.isContain("제로콜라")).isFalse()
        assertThat(drink.isContain("아이스크림")).isFalse()
    }

    @Test
    fun `메뉴의 가격을 올바르게 가져오는지 테스트`() {
        val appetizer = Course.APPETIZER

        assertThat(appetizer.getPrice("시저샐러드")).isEqualTo(8000)
    }

    @Test
    fun `주문한 갯수 만큼의 금액을 반환하는지 테스트`() {
        val menu = Menu("양송이수프",6000,5,Course.APPETIZER)
        assertThat(menu.getInitTotalPrice()).isEqualTo(30000)
    }

    @Test
    fun `디저트 갯수 세기 테스트`() {
        val myOrders = MyOrders(listOf(Menu("초코케이크",15000,3,Course.DESSERT),Menu("아이스크림",5000,2,Course.DESSERT)), Benefits(
            mutableListOf<ISaleEvent>()
        ))
        assertThat(myOrders.countDessert()).isEqualTo(5)
    }

    @Test
    fun `메인코스 갯수 세기 테스트`() {
        val myOrders = MyOrders(listOf(Menu("티본스테이크",55000,3,Course.MAIN_COURSE),Menu("아이스크림",5000,2,Course.DESSERT)), Benefits(
            mutableListOf<ISaleEvent>()
        ))
        assertThat(myOrders.countMainCourse()).isEqualTo(3)
    }

}