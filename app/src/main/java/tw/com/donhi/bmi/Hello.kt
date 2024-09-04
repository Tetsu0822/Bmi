package tw.com.donhi.bmi

class Hello {

}

fun main() {
    //主要建構子直接設值
    val p = Person(name = "Hank", weight = 65.5f, height = 1.7f) //記憶體內建立物件 p 的住址
    println(p.bmi())
    //Ctrl + P 顯示建構子內容
    var tetsu = Person(name = "Tetsu", weight = 76.2f, height = 1.72f)
    println(p.name + ":" + p.bmi())
    println(tetsu.name + ":" + tetsu.bmi())
    p.hello()
//    p.weight = 65.5f
//    p.height = 1.7f
    //Bmi

    val w = 65.5f
    val h = 1.7f
    val bmi = w / (h * h)
    println("BMI:" + bmi)

    /*
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
    */
}