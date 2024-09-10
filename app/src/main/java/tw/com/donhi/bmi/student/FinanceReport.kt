package tw.com.donhi.bmi.student

class FinanceReport : Report {
    override fun load() {
        println("Loading Finance Report")
    }

    override fun print(title: String) {
        println("Printing Finance Report")
    }
}