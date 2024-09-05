package tw.com.donhi.bmi

//Map 一組資料:key-Value
//Key:不可重複, Value:可重複
fun main() {
    val drinks = mutableMapOf<Int, String>(
        1 to "Coke",
        2 to "7-up",
        3 to "Wulong",
        4 to "Orange"
    )
    println(drinks)
    println(drinks.get(3))
    drinks.put(5, "water")
    println(drinks)
}