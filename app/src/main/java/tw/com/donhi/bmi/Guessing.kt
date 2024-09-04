package tw.com.donhi.bmi

//猜數字
fun main() {
    var secret = 7
    //可直接執行者，即為 第一階層的方法(function)
    print("請輸入一個數字(1-10): ")
    //在 commend Line輸入數字
    //readLine()會回傳可能是null的字串(String)
    // 等待輸入資料，並按 Enter 後執行下一行
    var input = readLine()
    //將 input 從 String 轉 數值 或 為 null 則給右方資料
    var num:Int = input?.toIntOrNull() ?: 0
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
    }
}