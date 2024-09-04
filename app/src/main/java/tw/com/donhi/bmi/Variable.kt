package tw.com.donhi.bmi

fun main() {
    var counter = 0;
    //累加
    counter = counter + 1 //遞增
    counter++ // 上行簡寫
    counter = counter - 1 //遞減
    println(counter)
    println(10 % 3) //餘數
    println(10 / 3) //除數
    println(10 / 3.0) //Double
    //Boolean
    var b = false;
    println(!b)
    // 且 AND, 或 OR
    var a = true;
    //兩者皆真, AND
    println(a && b)
    //兩者其一為真 即真, OR
    println(a || b)
    //
    val num = -8
    println(num <= 5 && num >= -3)
    //
    println(num > 5 || num < -3)

}