package thread

object StaticSynchronziedMethodMain {
    @JvmStatic
    fun main(args: Array<String>) {
//        one()
//        two()
//        three()
//        four()
        five()
    }



    /**
     * 验证同步方法与同步静态方法间的异步性
     */
    private fun one() {
        val task = StaticSynchronziedMethod()
        val threadA = StaticThreadA(task)
        val threadB = StaticThreadC(task)
        threadA.start()
        threadB.start()
    }

    /**
     * 同一个对象的同步静态方法的同步性
     */
    private fun two() {
        val task = StaticSynchronziedMethod()
        val threadA = StaticThreadA(task)
        val threadB = StaticThreadB(task)
        threadA.start()
        threadB.start()
    }

    /**
     * 多对象间的静态同步方法的同步性
     */
    private fun three() {
        val task = StaticSynchronziedMethod()
        val task2 = StaticSynchronziedMethod()
        val threadA = StaticThreadA(task)
        val threadB = StaticThreadB(task2)
        threadA.start()
        threadB.start()
    }


    /**
     * 验证同一个对象 synchronize(class)代码块 间的同步性
     */
    private fun four() {
        val task = StaticSynchronziedMethod()
        val threadA = StaticThreadC(task)
        val threadB = StaticThreadD(task)
        threadA.start()
        threadB.start()
    }

    /**
     * 验证多个对象 synchronize(class)代码块 间的同步性
     */
    private fun five() {
        val task = StaticSynchronziedMethod()
        val task2 = StaticSynchronziedMethod()
        val threadA = StaticThreadC(task)
        val threadB = StaticThreadD(task2)
        threadA.start()
        threadB.start()
    }
}


class StaticThreadA(private val task: StaticSynchronziedMethod) : Thread("A") {

    override fun run() {
        super.run()
        task.testStaticMethod()
    }
}

class StaticThreadB(private val task: StaticSynchronziedMethod) : Thread("B") {

    override fun run() {
        super.run()
        task.testStaticMethod()
    }
}

class StaticThreadC(private val task: StaticSynchronziedMethod) : Thread("C") {
    override fun run() {
        super.run()
        task.testMethod()
    }
}

class StaticThreadD(private val task: StaticSynchronziedMethod) : Thread("D") {

    override fun run() {
        super.run()
        task.testMethod()
    }
}


