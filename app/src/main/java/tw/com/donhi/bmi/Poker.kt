package tw.com.donhi.bmi

fun main() {
    //C, D, H, S
    var deck = mutableListOf<Int>()
    for (i in 0 until 52) { //until 直到小余..
        deck.add(i)
        if (i%13 == 0 && i != 0) println()
        //商
        val a = i/13
        //if..else.. 的 Expression 判斷式(傳回值)
        var type = if (a == 0) {
            "C"
        } else if (a == 1) {
            "D"
        } else if (a == 2) {
            "H"
        } else {
            "S"
        }
//        var type = "S"
//        if (a == 0) {
//            type = "C"
//        } else if (a == 1) {
//            type = "D"
//        } else if (a == 2) {
//            type = "H"
//        }
        print("${(i%13)+1}$type ") //Statement 敘述式(無回傳值)
    }
}