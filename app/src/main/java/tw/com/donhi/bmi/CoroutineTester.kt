package tw.com.donhi.bmi

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Coroutines有susopend功能，意指工作可以在暫停後恢復執行
//主執行緒
fun main() = runBlocking {
//    Thread() {
//        dosomething() //Blocking 阻塞式程式執行
//    }.start()
    //協程執行方式 1.launch{ 協程 }
    launch {
        dosomethingElse()
    }
    println("Hello ${Thread.currentThread().name}")

}

//suspend 指本程式可以被暫停
suspend fun dosomethingElse() {
    delay(1000L) //延遲 1 毫秒
    println("Do something..Else..${Thread.currentThread().name}")
}
fun dosomething() {
    println("Do something...${Thread.currentThread().name}")
}