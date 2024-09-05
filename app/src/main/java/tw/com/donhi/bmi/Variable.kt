package tw.com.donhi.bmi

fun main() {
    //集合 List
    var list = mutableListOf<Int>(2, 5, 8)
    println(list)
    list.add(13)
    println(list)
    list.removeAt(1)
    println(list)

    //陣列 array
    var array = intArrayOf(2,5,8)
    println(array) //印出的是陣列的住址
    println(array.size) //size 計算有多少元素
    println(array[2])   //印出第 n 個數值
    //println(array[3])   //Excpetion 例外

    //字串陣列
    var ss = arrayOf("星期日","星期一","星期二")
    println(ss.size)
    println(ss.get(0))
    for (day in ss) {
        println(day)
    }

    //重複一定次數程式 For 迴圈
    //range 代表一定的範圍
    var range = 0..10
    for (i in 1..30) {
        if (i%2 == 1) {
            print("*")
        } else {
            print(" ")
        }
    }
    println()
    for (i in 1..10 step 2) print(i)
    println()

    //null 空值
    var name:String? = "Tetsu" // String + ? 表 name 可以為空值(null)
    println(name?.length) // name? 表若 name 不是 null 才會繼續執行 length
    //ALT + Enter 提供錯誤的處理方法
    if (name != null) {
        println(name.length)
    }
    // 貓王符號 ?: 表左方若為 null 則會得到 右方的資料
    println(name ?: 0)

    var counter = 0;
    //累加
    counter = counter + 1 //遞增
    counter++ // 上行簡寫
    counter = counter - 1 //遞減
//    println(counter)
//    println(10 % 3) //餘數
//    println(10 / 3) //除數
//    println(10 / 3.0) //Double
    //Boolean
    var b = false;
//    println(!b)
    // 且 AND, 或 OR
    var a = true;
    //兩者皆真, AND
//    println(a && b)
    //兩者其一為真 即真, OR
//    println(a || b)
    //
    val num = -8
//    println(num <= 5 && num >= -3)
    //
//    println(num > 5 || num < -3)

}