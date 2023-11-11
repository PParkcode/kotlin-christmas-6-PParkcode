package christmas

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
class MenuTest {

    @Test
    fun `해당 메뉴가 있는지 확인`() {
        val appetizer =Course.Appetizer
        val mainCourse = Course.MainCourse
        val dessert = Course.Dessert
        val drink = Course.Drink

        assertThat(appetizer.isContain("양송이수프")).isTrue()
        assertThat(mainCourse.isContain("바비큐립")).isTrue()
        assertThat(dessert.isContain("제로콜라")).isFalse()
        assertThat(drink.isContain("아이스크림")).isFalse()
    }

    @Test
    fun `메뉴의 가격을 올바르게 가져오는지 테스트`() {
        val appetizer = Course.Appetizer

        assertThat(appetizer.getPrice("시저샐러드")).isEqualTo(8000)
    }
}