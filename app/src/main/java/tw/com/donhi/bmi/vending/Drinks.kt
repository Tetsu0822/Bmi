package tw.com.donhi.bmi.vending

//Map 一組資料:key-Value
//Key:不可重複, Value:可重複
fun main() {
    var tea = Drink("Black tea", 0, 50)
    println(tea)
    //複製舊物件以產生新物件並可微調
    val tea2 = tea.copy(suger = 5)
    println(tea2)

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