package thread


object MainTwo {
    @JvmStatic
    fun main(args: Array<String>) {
//        one()
//        two()
        three()
    }


    /**
     * 非同步方法
     */
    private fun one() {
        val task = TaskTwo()
        val threadAA = ThreadAA(task)
        threadAA.start()
        val threadBB = ThreadBB(task)
        threadBB.start()
        Thread.sleep(10000)
        var beginTime = TimeUtils.beginTime1
        if (beginTime!! > TimeUtils.beginTime2!!) {
            beginTime = TimeUtils.beginTime2
        }
        var endTime = TimeUtils.endTime1
        if (beginTime!! < TimeUtils.endTime2!!) {
            endTime = TimeUtils.endTime2
        }
        println("操作用时: ${(endTime!! - beginTime) / 1000}")
    }

    /**
     * 同步方法
     */
    private fun two() {
        val task = TaskOne()
        val threadAA = ThreadAA(task)
        threadAA.start()
        val threadBB = ThreadBB(task)
        threadBB.start()
        Thread.sleep(10000)
        var beginTime = TimeUtils.beginTime1
        if (beginTime!! > TimeUtils.beginTime2!!) {
            beginTime = TimeUtils.beginTime2
        }
        var endTime = TimeUtils.endTime1
        if (beginTime!! < TimeUtils.endTime2!!) {
            endTime = TimeUtils.endTime2
        }
        println("操作用时: ${(endTime!! - beginTime) / 1000}")
    }

    private fun three() {
        val task = TaskThree()
        val threadAA = ThreadAA(task)
        threadAA.start()
        val threadBB = ThreadBB(task)
        threadBB.start()
        Thread.sleep(10000)
        var beginTime = TimeUtils.beginTime1
        if (beginTime!! > TimeUtils.beginTime2!!) {
            beginTime = TimeUtils.beginTime2
        }
        var endTime = TimeUtils.endTime1
        if (beginTime!! < TimeUtils.endTime2!!) {
            endTime = TimeUtils.endTime2
        }
        println("操作用时: ${(endTime!! - beginTime) / 1000}")
    }
}


interface Task {
    fun doLongTimeTask()
}

class TaskOne : Task {
    private var data1: String? = null
    private var data2: String? = null

    @Synchronized
    override fun doLongTimeTask() {
        println("begin task")
        Thread.sleep(3000)
        data1 = "长时间任务返回值 1 thread name is ${Thread.currentThread().name}"
        data2 = "长时间任务返回值 2 thread name is ${Thread.currentThread().name}"
        println("$data1")
        println("$data2")
        println("end task")
    }
}

class TaskTwo : Task {
    private var data1: String? = null
    private var data2: String? = null

    override fun doLongTimeTask() {
        println("begin task")
        Thread.sleep(3000)
        data1 = "长时间任务返回值 1 thread name is ${Thread.currentThread().name}"
        data2 = "长时间任务返回值 2 thread name is ${Thread.currentThread().name}"
        println("$data1")
        println("$data2")
        println("end task")
    }
}

class TaskThree : Task {
    private var data1: String? = null
    private var data2: String? = null

    override fun doLongTimeTask() {
        println("begin task")
        Thread.sleep(3000)
        synchronized(this) {
            data1 =  "长时间任务返回值 1 thread name is ${Thread.currentThread().name}"
            data2 = "长时间任务返回值 2 thread name is ${Thread.currentThread().name}"
            println("$data1")
            println("$data2")
        }
        println("end task")
    }
}


object TimeUtils {
    var beginTime1: Long? = 0
    var endTime1: Long? = 0
    var beginTime2: Long? = 0
    var endTime2: Long? = 0
}

class ThreadAA(private val taskOne: Task) : Thread() {


    override fun run() {
        super.run()

        TimeUtils.beginTime1 = System.currentTimeMillis()
        taskOne.doLongTimeTask()
        TimeUtils.endTime1 = System.currentTimeMillis()
    }
}

class ThreadBB(private val taskOne: Task) : Thread() {


    override fun run() {
        super.run()

        TimeUtils.beginTime2 = System.currentTimeMillis()
        taskOne.doLongTimeTask()
        TimeUtils.endTime2 = System.currentTimeMillis()
    }
}