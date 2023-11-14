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

}