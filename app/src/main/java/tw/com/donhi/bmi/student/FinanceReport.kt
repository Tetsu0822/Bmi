package tw.com.donhi.bmi.student

//繼承類別後必須實作 implement
class FinanceReport : Report {
    override fun load() {
        println("Loading Finance Report")
    }

    override fun print(title: String) {
        println("Printing Finance Report")
    }
}