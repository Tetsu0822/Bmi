package tw.com.donhi.bmi

class Person {
    //儲存資料
    var weight:Float = 0f
    var height:Float = 0f

    fun bmi() : Float {
        val bmi = weight/(height*height)
        return bmi
    }

    // ()內可加傳入值
    fun hello() {
        println("Hello")
    }
}