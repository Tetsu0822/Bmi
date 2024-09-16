package tw.com.donhi.bmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//類別建立後，首先繼承ViewModel
class GuessViewModel : ViewModel() {
    var serect = (1..10).random()
    //預先設計未來可能需要提供監聽
    val serectData = MutableLiveData<Int>()
    val counter = MutableLiveData<Int>()
    val status = MutableLiveData<GameStatus>()
    //初始化
    init {
        counter.value = 0
        status.value = GameStatus.INIT
    }

    fun guess(num : Int) {
        status.value = when(num - serect) {
            //Int.MAX_VALUE 表Int的最大值
            in 1..Int.MAX_VALUE -> GameStatus.SMALLER
            0 -> GameStatus.NUMBER_RIGHT
            else -> GameStatus.BIGGER
        }
        var c = counter.value ?: 0
        c++
        counter.value = c
    }

    fun reset() {
        serect = (1..10).random()
        counter.value = 0
        status.value = GameStatus.INIT
    }
}

enum class GameStatus {
    INIT, BIGGER, SMALLER, NUMBER_RIGHT
}