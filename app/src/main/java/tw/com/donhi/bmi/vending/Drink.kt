package tw.com.donhi.bmi.vending

//類別若無繼承，則會自動繼承java.lang.Object, Kotlin.Any
//若要執行Object內的方法，則要複寫(Ctrl+O)其方法
//data class 自動複寫基本方法
data class Drink(val name:String, val suger:Int, val price:Int) {
//    override fun toString(): String {
//        //return super.toString()
//        return "$name $suger $price"
//    }
}