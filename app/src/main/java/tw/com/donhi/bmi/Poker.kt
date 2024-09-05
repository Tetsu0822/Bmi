package tw.com.donhi.bmi

fun main() {
    //Set 集合:不重複資料，重複的資料將被移除
    //特性:資料沒有順序(無索引值 index)
    val set = setOf<Int>(5,3,9,3,2,1,9)
    println(set)
    //列出每一個值(無命名)
    set.forEach {
        println(it)
    }
    //有命名
    set.forEach { num ->
        println(num)
    }
    //C, D, H, S
    //List 特性1:有索引值 index
    //List 特性2:值可重複
    val list = listOf<Int>(5,3,8,5,3,2,1)
    println(list)
    var deck = mutableListOf<Int>()

    for (i in 0 until 52) { //until 直到小余..
        deck.add(i)
        if (i%13 == 0 && i != 0) println()
        //商
        val a = i/13
        //多層次的判斷，可用 Kotlin 的 when 語法
        //語法 1 :針對一個值
        var type = when (a) {
            0 -> "♣"
            1 -> "♢"
            2 -> "♡"
            else -> "♠"
        }
        //11->J, 12->Q, 13->K By Tetsu
        var tmp:String
        var fine = (i%13)+1
        if (fine > 10) {
            when (fine) {
                11 -> {
                    tmp = "J"
                    print("$tmp$type ")
                }
                12 -> {
                    tmp = "Q"
                    print("$tmp$type ")
                }
                13 -> {
                    tmp = "K"
                    print("$tmp$type ")
                }else -> {}
            }
        } else {
            print("$fine$type ")
        }
        //print("${(i%13)+1}$type ") //Statement 敘述式(無回傳值)

        //if..else.. 的 Expression 判斷式(傳回值)
        /*var type = if (a == 0) {
            "C"
        } else if (a == 1) {
            "D"
        } else if (a == 2) {
            "H"
        } else {
            "S"
        }*/
//        var type = "S"
//        if (a == 0) {
//            type = "C"
//        } else if (a == 1) {
//            type = "D"
//        } else if (a == 2) {
//            type = "H"
//        }
    }
    println()
    println(deck)
    //若集合為mutableList 則可使用shuffle 打亂順序
    deck.shuffle()
    //打亂順序並產生第 2 個集合
    val deck2 = deck.shuffled()
    println("deck: $deck")
    println("deck2: $deck2")
    // 值有可能重複
    val a = deck.shuffled().first()
    val b = deck.shuffled().first()
}