package tw.com.donhi.bmi

import kotlin.random.Random

//猜數字
fun main() {
    //產生亂數
    //Random 內涵static方法 可直接使用的類別
    // .next...回傳各類型值
    //println(Random.nextInt(from = 1, until = 11))
    //使用範圍
    //println((1..10).random())

    var secret = (1..10).random()
    println("secret: $secret")
    var num = 0
    //重複執行程式碼 while 迴圈
    //不建議使用 while(true)，建議使用判斷式
//    while (num != secret) {
    var bingo = false
    for (i in 1..3) {
        //可直接執行者，即為 第一階層的方法(function)
        print("請輸入一個數字(1-10): ")
        //在 commend Line輸入數字
        //readLine()會回傳可能是null的字串(String)
        // 等待輸入資料，並按 Enter 後執行下一行
        var input = readLine()
        //將 input 從 String 轉 數值 或 為 null 則給右方資料
        num = input?.toIntOrNull() ?: 0
        println("你輸入的值為: " + num)
        //將 結果崁入字串，若結果是運算得來的，則要在字串內使用大括弧{}包覆
        //println("你輸入的值為: $num ${input?.length}")

        // if..else..判斷式
        if ( num < secret ) {
            println("再大一點!")
        } else if ( num > secret ) {
            println("再小一點!")
        } else {
            println("你猜對了!")
            bingo = true
            break
        }
    }

    if (!bingo) {
        println("你失敗了，數字為: $secret")
    }
}