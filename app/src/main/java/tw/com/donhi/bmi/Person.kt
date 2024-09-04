package tw.com.donhi.bmi

/*
//建構子 constructor
//1.主要建構子 將類別屬性建立在建構子內
 */
class Person(val name:String, val weight:Float, val height:Float) {
    //儲存資料 weight,height變數轉成類別的屬性
//    var weight:Float = 0f
//    var height:Float = 0f

    fun bmi() : Float {
        // bmi 為一般的區域變數
        val bmi = weight/(height*height)
        return bmi
    }

    // ()內可加傳入值
    fun hello() {
        println("Hello")
    }
}