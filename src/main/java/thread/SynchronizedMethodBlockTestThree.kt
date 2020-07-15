package thread


object MainBlockTestAA {
    @JvmStatic
    fun main(args: Array<String>) {
//        one()
        two()
    }

    /**
     * 非同步
     */
    private fun one() {
        val task = TaskBlockTesThree()
        val threadAA = ThreadAAAA(task)
        threadAA.start()
        val threadBB = ThreadBBBB(task)
        threadBB.start()
    }

    /**
     * synchronzied(非 this 对象) 同步代码块
     */
    private fun two() {
        val task = TaskBlockTesThree2()
        val threadAA = ThreadAAAA(task)
        threadAA.start()
        val threadBB = ThreadBBBB(task)
        threadBB.start()
    }
}


open class TaskBlockTesThree : Task {

    var age: Int? = null
    var name: String? = null

    override fun doLongTimeTask() {}

    open fun setNameAge(age: Int, name: String) {
        println("begin 调用的线程名为 ：${Thread.currentThread().name}")
        this.age = age
        Thread.sleep(3000)
        this.name = name
        println("end 调用的线程名为：${Thread.currentThread().name},age is ${this.age},name is ${this.name}")
    }

}

class TaskBlockTesThree2 : TaskBlockTesThree() {

    val str: String = ""
    override fun setNameAge(age: Int, name: String) {

        synchronized(str) {
            println("begin 调用的线程名为 ：${Thread.currentThread().name}")
            super.age = age
            Thread.sleep(3000)
            super.name = name
            println("end 调用的线程名为：${Thread.currentThread().name},age is ${this.age},name is ${this.name}")
        }
    }

}


class ThreadAAAA(private val task: TaskBlockTesThree) : Thread() {


    override fun run() {
        super.run()
        task.setNameAge(1, "one")

    }
}

class ThreadBBBB(private val task: TaskBlockTesThree) : Thread() {


    override fun run() {
        super.run()
        task.setNameAge(2, "two")
    }
}