package tw.com.donhi.bmi.vending

//Map 一組資料:key-Value
//Key:不可重複, Value:可重複
fun main() {
    val s = "abcdf"
    println(s.validate())
    val tea = Drink("Black tea", 0, 50)
    val discountTea = tea.off20()
    println(tea)
    println(discountTea)
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

//擴充功能 extensions
//回傳新的物件
fun Drink.off20() : Drink {
    return this.copy(price = (this.price * 0.8).toInt())
}
fun String.validate() : Boolean {
    return this.length >= 6
}