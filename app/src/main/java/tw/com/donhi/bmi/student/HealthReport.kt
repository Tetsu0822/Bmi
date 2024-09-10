package tw.com.donhi.bmi.student
//繼承類別後必須實作 implement
class HealthReport : Report {
    override fun load() {
        println("Loading Health...")
    }

    override fun print(title: String) {
        println("Printing Health...")
    }
}