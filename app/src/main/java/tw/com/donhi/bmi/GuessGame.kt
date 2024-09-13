package tw.com.donhi.bmi

import kotlin.random.Random

//物件導向
//特性 1：Inheritance繼承
//特性 2：Polymorphism多型
//特性 3：Encapsulation封裝
class GuessGame {
    //Enumeration 列舉
    enum class Status {
        INIT, BIGGER, SMALLER, BINGO
    }

    var secret:Int = Random.nextInt(1, 1)
    var counter = 0 //屬性
    var status = Status.INIT
    fun guess(n:Int) : Status {
        //return secret - n
        return if (n > secret) Status.SMALLER
        else if (n < secret) Status.BIGGER
        else Status.BINGO
    }
    fun reset() {
        secret = Random.nextInt(1, 1)
        counter = 0
    }
}

fun main() {
    val game = GuessGame()
    val num = 3
    val result = game.guess(num)

}