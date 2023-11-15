package christmas.user

import christmas.data.Course


class Menu(
    private val name: String,
    private val initPrice: Int,
    private val count: Int,
    private val course: Course,
) {
    fun getInitTotalPrice(): Int {
        return initPrice * count
    }

    fun isEqualCourse(courseName: String): Int {
        if (course.name == courseName) {
            return count
        }
        return 0
    }

    fun getName(): String {
        return name
    }

    fun getCount(): Int {
        return count
    }

}
