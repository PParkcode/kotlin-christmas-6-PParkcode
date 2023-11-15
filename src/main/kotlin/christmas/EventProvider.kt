package christmas

class EventProvider(private val myOrders: MyOrders, private val date: Date) {



    fun getMyBenefits() {
        // 적용 가능한 이벤트들을 출력해야 함.
        // 출력 전에 먼저 이벤트 적용을 시켜야 함.
        // 그리고 적용 안되는 이벤트는 무시

        //1. 크리스마스 디데이 할인 진행V
        //2. 평일인지 주말인지 확인 후 주중 할인 진행. -> 둘중하나를 적용해야 함. 안될 수도 있음.
        //3. 특별 이벤트를 진행 -> 주말 혹은 25일인지 알아야 함.
        //4. 증정 이벤트 적용
        // 다 적용 했으면, myOrder에 접근해서 0원 이하인 것들만 출력?


    }

    fun applyEvents() {
        applyChristmasSale()
        applyWeekSale()
        applySpecialSale()
        applyGiftEvent()
    }

    fun printMyBenefits() {
        myOrders.printMyBenefits()
    }

    private fun applyChristmasSale() {
        val christmasSale = date.getChristmasSale()
        if(christmasSale>0) {
            myOrders.applyChristmasEvent(christmasSale)
        }
    }

    private fun applyWeekSale() {
        if(date.isWeekend()) {
            applyWeekendSale()
            return
        }
        applyWeekDaySale()
    }
    private fun applySpecialSale() {
        if(date.isSpecialSaleDay()) {
            myOrders.applySpecialEvent(1000)
        }
    }

    private fun applyGiftEvent() {
        if (myOrders.getInitTotalPrice() >= 120000) {
            myOrders.applyGiftEvent(Course.Drink.getPrice("샴페인"))

        }
    }

    private fun applyWeekDaySale() {
        val numOfDessert = myOrders.countDessert()
        val weekdaySale = 2023 * numOfDessert
        if(weekdaySale>0) {
            myOrders.applyWeekdayEvent(weekdaySale)
        }

    }

    private fun applyWeekendSale() {
        val numOfMainCourse = myOrders.countMainCourse()
        val weekendSale = 2023 * numOfMainCourse
        myOrders.applyWeekendEvent(weekendSale)
    }
}