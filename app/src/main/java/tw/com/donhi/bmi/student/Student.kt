package tw.com.donhi.bmi.student

//學生有學號、姓名、英文、數學成績
//印出學生資料
//印出學生平均成績
//以平均成績印出學生等級(A,B,C,D,E,F)

//設計藍圖
//類別(屬性)只能在第一層定義，其他均為區域變數 Local variable
//主建構子可預先設定值
//open 表可以讓其他類別繼承
open class Student(val id: String, val name: String,
                var english: Int = 0, var math: Int = 0) {
    //類別層級的屬性(物件共用一屬性) static, Companion Object(陪同型物件)
    companion object {
        var pass = 60
    }

    //次要建構子是為了讓類別在某些情境上的使用，更能夠符合他們的需求
    //冒號後為回傳至主要建構子
//    constructor(id: String, name: String) : this(id,name,0,0)
    fun print() {
        val mark = if (average() < pass) "*" else " "
        // /t 為定位點即空白
        println("$id\t$name\t$english\t$math\t${average()}$mark\t${grading()}")
    }
    //簡化成下面 fun
    /*fun average() : Int {
        return (english + math)/2
    }*/
    fun average() = (english + math)/2

    fun grading() = when(average()/10) {
        9,10 -> "A"
        8    -> "B"
        7    -> "C"
        6    -> "D"
        else -> "F"
    }
    //簡化成上面 fun
    /*fun grading() : String {
        return when(average()/10) {
            9,10 -> "A"
            8    -> "B"
            7    -> "C"
            6    -> "D"
            else -> "F"
        }
    }*/

}

//演練實作程式
//Companion
fun main() {
    //物件產生前可以使用Companion Object
    Student.pass = 50
    //利用集合印出學生資料
    var students = listOf<Student>(
        Student("001", "Jack", 40, 60),
        Student("002", "Tetsu", 95, 99),
        Student("003", "Jane")
    )
    //直接讓集合列出每一個資料
    for (stu in students) {
        stu.print()
    }

    /*for (i in 0..2) {
        students.get(i).print()
    }
    var stu1 = Student("001", "Jack", 100, 100)
    var stu2 = Student("002", "Tetsu", 95, 99)
    var stu3 = Student("003", "Jane")
    stu1.print()
    stu2.print()
    stu3.print()*/
}