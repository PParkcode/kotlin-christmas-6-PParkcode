package christmas.exception

class ExceptionChecker {

    fun checkDate(date:String) {
        isDigitDate(date)
        isInRange(date.toInt())
    }

    private fun isDigitDate(date: String) {
        if(date=="") {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
        for(digit in date) {
            if(!digit.isDigit()) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
            }
        }
    }
    private fun isInRange(date:Int) {
        if(1>date || date>31) {
            throw IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }
}