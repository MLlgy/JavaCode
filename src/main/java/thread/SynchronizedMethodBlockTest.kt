package thread


object MainBlockTest {
    @JvmStatic
    fun main(args: Array<String>) {
        one()
    }

    private fun one() {
        val task = TaskBlockTest()
        val threadAA = ThreadAA(task)
        threadAA.start()
        val threadBB = ThreadBB(task)
        threadBB.start()
    }
}


class TaskBlockTest : Task {

    override fun doLongTimeTask() {
        for (index in 0..5) {
            println("调用线程名称：${Thread.currentThread().name}, i = $index")
        }
        println("====")
        synchronized(this) {
            for (index in 0..5) {
                println("同步代码块调用线程名称：${Thread.currentThread().name}, i = $index")
            }
        }
    }
}





