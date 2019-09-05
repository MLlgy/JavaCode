package thread


object MainBlockTestA {
    @JvmStatic
    fun main(args: Array<String>) {
        one()
    }

    private fun one() {
        val task = TaskBlockTestTwo()
        val threadAA = ThreadAAA(task)
        threadAA.start()
        val threadBB = ThreadBBB(task)
        threadBB.start()
    }
}


class TaskBlockTestTwo : Task {

    override fun doLongTimeTask() {

        synchronized(this) {
            println("ThreadPerTaskExecutor begin time is :${System.currentTimeMillis()}" )
            Thread.sleep(2000)
            println("ThreadPerTaskExecutor end time is :${System.currentTimeMillis()}")
        }
    }

    fun methodA(){
        synchronized(this) {
            println("B begin time is :${System.currentTimeMillis()}" )
            Thread.sleep(2000)
            println("B end time is :${System.currentTimeMillis()}")
        }
    }
}


class ThreadAAA(private val taskOne: Task) : Thread() {


    override fun run() {
        super.run()
        taskOne.doLongTimeTask()
    }
}

class ThreadBBB(private val taskOne: TaskBlockTestTwo) : Thread() {


    override fun run() {
        super.run()
        taskOne.methodA()
    }
}