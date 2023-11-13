package christmas.io

class UserInterface(
    private val output: OutputView = OutputView(),
    private val input: InputView = InputView()
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

    fun askMenus(): List<Pair<String,Int>>{
        var menus: List<Pair<String,Int>>
        while(true) {
            try {
                menus = input.readMenu()
                return menus
            } catch (e:IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}