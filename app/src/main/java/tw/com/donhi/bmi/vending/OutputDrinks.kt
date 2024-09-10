package tw.com.donhi.bmi.vending

import java.io.File

fun main() {
    val drinks = listOf<Drink>(
        Drink("Black Tea", 0, 50),
        Drink("Green Tea", 5, 45),
        Drink("Wuloan Tea", 0, 60)
    )
    //輸出資料到檔案
    //File 開啟檔案
    //printWriter() 取得資料串流
    // out 即為OutputStream 輸出串流
    val out = File("order.txt").printWriter()
    for (d in drinks) {
        out.println("${d.name},${d.suger},${d.price}")
        //out.flush() //輸出資料到檔案
    }
    //out.flush()

    //BufferedWriter 有緩衝區的類別輸出(資料多時建議使用)
    val out2 = File("order.txt").bufferedWriter()
    for (d in drinks) {
        out2.write("${d.name},${d.suger},${d.price}\n")
    }
    out.flush()
}