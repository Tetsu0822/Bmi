package tw.com.donhi.bmi

fun main() {
    //C, D, H, S
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
}