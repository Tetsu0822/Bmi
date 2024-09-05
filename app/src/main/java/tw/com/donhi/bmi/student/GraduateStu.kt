package tw.com.donhi.bmi.student

//子類別(Sub Class)繼承父類別(Super Class)
class GraduateStu(id: String, name: String,
                  english: Int, math: Int, val thesis: Int)
    : Student(id, name, english, math) {
        //複寫父類別方法

}

fun main() {
    val gstu = GraduateStu("008", "Emma", 90, 90, 85)
    gstu.print()

}