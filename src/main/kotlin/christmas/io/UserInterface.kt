package christmas.io

class UserInterface(
    private val output: OutputView,
    private val input: InputView
) {
    fun printIntroMsg() {
        output.printIntroMsg()
    }

    fun askDate(): Int {
        var date: Int
        while (true) {
            try {
                date = input.readDate()
                return date
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}