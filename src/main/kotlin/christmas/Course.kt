package christmas

enum class Course(val nameToPrice:Map<String,Int>) {
    Appetizer(mapOf("양송이수프" to 6_000,"타파스" to 5_500, "시저샐러드" to 8_000)),
    MainCourse(mapOf("티본스테이크" to 55_000, "바비큐립" to 54_000, "해산물 파스타" to 35_000,"크리스마스파스타" to 25_000)),
    Dessert(mapOf("초코케이크" to 15_000, "아이스크림" to 5_000)),
    Drink(mapOf("제로콜라" to 3_000, "레드와인" to 60_000, "샴페인" to 25_000));

    fun isContain(food: String):Boolean {
        return nameToPrice.containsKey(food)
    }
    fun getPrice(food:String): Int {
        return nameToPrice[food]!!
    }
}