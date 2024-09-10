package tw.com.donhi.bmi.student

//行為的規範
//設計方法的行為而不用實作(未來統一的介面),implement
interface Report {
    fun load()

    fun print(title: String)
}