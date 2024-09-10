package tw.com.donhi.bmi.student

//抽象類別
abstract class MyReport {
    abstract fun load()

    fun print() {
        println("Printing")
    }

    fun init() {

    }
}