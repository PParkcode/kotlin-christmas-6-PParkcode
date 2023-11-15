package christmas


class Menu(
    val name: String,
    val initPrice: Int,
    val count: Int,
    val course: Course,
    val finalPrice: Int
) {
    fun getInitTotalPrice(): Int {
        return initPrice * count
    }
    fun isEqualCourse(courseName:String):Int {
        if(course.name == courseName) {
            return count
        }
        return 0
    }

}
