package copy

object DeepMain {

    @JvmStatic
    fun main(args: Array<String>) {
        val deepStudent =  DeepCloneStudent(1, "杰克")
        val  deepCloneStudent =deepStudent.clone() as DeepCloneStudent
        printMessage(deepStudent, deepCloneStudent)

        deepStudent.subject.name = "幻觉"
        printMessage(deepStudent, deepCloneStudent)
        deepCloneStudent.subject.name = "再见杰克"
        printMessage(deepStudent, deepCloneStudent)
    }

    private fun printMessage(deepStudent: DeepCloneStudent, deepCloneStudent: DeepCloneStudent) {
        println("origin student's age is ${deepStudent.age} the name is ${deepStudent.name} and the subject's name is ${deepStudent.subject.name}")
        println("deepCopy student's age is ${deepCloneStudent.age} the name is ${deepCloneStudent.name} and the subject's name is ${deepCloneStudent.subject.name}")
        println("=============")
    }
}