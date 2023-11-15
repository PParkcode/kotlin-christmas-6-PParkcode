package christmas

import christmas.event.*
import christmas.user.Benefits
import christmas.user.Date
import christmas.user.MyOrders
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class SaleTest {


    @Test
    fun `날짜 별 크리스마스 디데이할인 금액 테스트1`() {
        val date = Date(25,"MONDAY")
        val saleAmount = date.getChristmasSale()
        assertThat(saleAmount).isEqualTo(3400)
    }
    @Test
    fun `날짜 별 크리스마스 디데이할인 금액 테스트2`() {
        val date = Date(1,"FRIDAY")
        val saleAmount = date.getChristmasSale()
        assertThat(saleAmount).isEqualTo(1000)
    }

    @Test
    fun `날짜 별 크리스마스 디데이할인 금액 테스트3`() {
        val date = Date(26,"TUESDAY")
        val saleAmount = date.getChristmasSale()
        assertThat(saleAmount).isEqualTo(0)
    }

    @Test
    fun `총 혜택 금액 테스트`() {
        val benefits =Benefits(mutableListOf<ISaleEvent>(ChristmasSale("",1300),WeekdaySale("",2023),SpecialSale("",1000)))
        assertThat(benefits.getTotalBenefitAmount()).isEqualTo(4323)
    }

    @Test
    fun `총 혜택 금액 테스트2`() {
        val benefits =Benefits(mutableListOf<ISaleEvent>(ChristmasSale("",1300),
            WeekendSale("",2023),GiftEvent("",25000)))
        assertThat(benefits.getTotalBenefitAmount()).isEqualTo(28323)
    }

    @Test
    fun `증정 상품 가격을 제외하고, 얼만큼 할인되는지 테스트`() {
        val benefits =Benefits(mutableListOf<ISaleEvent>(ChristmasSale("",1300),
            WeekendSale("",2023),GiftEvent("",25000)))
        assertThat(benefits.getTotalDiscount()).isEqualTo(3323)
    }






}