package tw.com.donhi.bmi.vending

import java.io.File

//讀取檔案資料
fun main() {
    val drinks = mutableListOf<Drink>()
    val input = File("order.txt").bufferedReader()
    var line = input.readLine() //取得行列且無跳行

    while (line != null) {
        println(line)
        //Black Tea,0,50
        val tokens = line.split(",") //將字串拆解成區塊,切割字元為逗號
        //產生陣列
        val drink = Drink(tokens[0], tokens[1].toInt(),
            tokens[2].toInt())
        drinks.add(drink) //加入一行資料
        line = input.readLine() //迴圈讀取下一行
    }
    println(drinks) //印出物件
}