package tw.com.donhi.bmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//類別建立後，首先繼承ViewModel
class GuessViewModel : ViewModel() {
    val counter = MutableLiveData<Int>()
    init {
        counter.value = 0
    }

    fun guess(num : Int) {
        var c = counter.value ?: 0
        c++
        counter.value = c
    }
}