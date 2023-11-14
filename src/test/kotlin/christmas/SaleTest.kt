package christmas

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class SaleTest {

    @Test
    fun `날짜 별 크리스마스 디데이할인 금액 테스트1`() {
        val date = Date(25)
        val saleAmount = date.getChristmasSale()
        assertThat(saleAmount).isEqualTo(3400)
    }
    @Test
    fun `날짜 별 크리스마스 디데이할인 금액 테스트2`() {
        val date = Date(1)
        val saleAmount = date.getChristmasSale()
        assertThat(saleAmount).isEqualTo(1000)
    }

    @Test
    fun `날짜 별 크리스마스 디데이할인 금액 테스트3`() {
        val date = Date(26)
        val saleAmount = date.getChristmasSale()
        assertThat(saleAmount).isEqualTo(0)
    }

    @Test
    fun `요일 확인 기능 테스트1`(){
        val date = Date(1)
        val dayOfWeek = date.getDayOfWeek()
        assertThat(dayOfWeek).isEqualTo("FRIDAY")
    }
    @Test
    fun `요일 확인 기능 테스트2`(){
        val date = Date(2)
        val dayOfWeek = date.getDayOfWeek()
        assertThat(dayOfWeek).isEqualTo("SATURDAY")
    }
    @Test
    fun `요일 확인 기능 테스트3`(){
        val date = Date(3)
        val dayOfWeek = date.getDayOfWeek()
        assertThat(dayOfWeek).isEqualTo("SUNDAY")
    }
    @Test
    fun `요일 확인 기능 테스트4`(){
        val date = Date(4)
        val dayOfWeek = date.getDayOfWeek()
        assertThat(dayOfWeek).isEqualTo("MONDAY")
    }
    @Test
    fun `요일 확인 기능 테스트5`(){
        val date = Date(5)
        val dayOfWeek = date.getDayOfWeek()
        assertThat(dayOfWeek).isEqualTo("TUESDAY")
    }
    @Test
    fun `요일 확인 기능 테스트6`(){
        val date = Date(6)
        val dayOfWeek = date.getDayOfWeek()
        assertThat(dayOfWeek).isEqualTo("WEDNESDAY")
    }
    @Test
    fun `요일 확인 기능 테스트7`(){
        val date = Date(7)
        val dayOfWeek = date.getDayOfWeek()
        assertThat(dayOfWeek).isEqualTo("THURSDAY")
    }

}