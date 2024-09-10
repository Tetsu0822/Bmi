package tw.com.donhi.bmi.vending

import java.net.URL

fun main() {
    //https://donhi.com.tw/uploads/API/news2.json
    passSSL.ignoreSsl()
    val input = URL("https://donhi.com.tw/uploads/API/news3.json").openStream()
    val reader = input.bufferedReader()
    var line = reader.readLine()
    while (line!=null) {
        println(line)
        line = reader.readLine()
    }
}