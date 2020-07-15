package twlven


val echo = {name:String -> println(name)}

fun main(args: Array<String>) {

    val thread = Thread({ -> println("kotlin") })
    val thread2 = Thread({ -> Unit })
//    val thread3 = Thread{ println("kotlin")}
//    val thread3 = Thread{ println("kotlin")}
    echo.invoke("kotlin")
    echo("kotlind")
}
