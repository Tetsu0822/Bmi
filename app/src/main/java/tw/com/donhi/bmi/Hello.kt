package tw.com.donhi.bmi

class Hello {

}

fun main() {
    val p = Person() //記憶體內建立物件 p 的住址
    p.hello()

    println("Hello Kotlin!")

    //Byte(8bits), Short(16), Int(32), Long(64)
    val age:Int = 20 //val 定義不可變動的變數，可省略 :Int 由程式自動判斷
    val population:Long = 9999L //L 代表 Long 故可省略定義 :Long
    println(age.inc())
    println(age)
    var name = "Tetsu" //var 定義可變動的變數
    println(name.get(1))
    name = "Jack"
    println(name)
    //Float(32), Double(64)
    val weight:Float = 65.5f //加 f 表使用Float，或使用.toFloat() 讓Double 轉 Float
    //true, false 布林值
    val isAdult = false
    //Char 字元 需使用 單引號
    var c ='A'
    println(c)
}