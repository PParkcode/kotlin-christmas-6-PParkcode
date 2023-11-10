package christmas.io

import camp.nextstep.edu.missionutils.Console
import christmas.exception.ExceptionChecker

class InputView(private val checker: ExceptionChecker = ExceptionChecker()) {

    fun readDate():Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val date = Console.readLine()
        checker.checkDate(date)
        return date.toInt()
    }
}