package tw.com.donhi.bmi

class Hello {

}

fun main() {
    println("Hello Kotlin!")
    //Byte, Short, Int, Long
    val age = 20 //val 定義不可變動的變數
    val population = 9999L
    println(age.inc())
    println(age)
    var name = "Tetsu" //var 定義可變動的變數
    println(name.get(1))
    name = "Jack"
    println(name)
    //Float(32), Double(64)
    val weight:Float = 65.5f
    //true, false
    val isAdult = false
    //Char
    var c ='A'
    println(c)
}