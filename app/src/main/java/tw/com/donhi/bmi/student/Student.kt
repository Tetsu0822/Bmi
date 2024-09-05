package tw.com.donhi.bmi.student

//學生有學號、姓名、英文、數學成績
//印出學生資料
//印出學生平均成績
//以平均成績印出學生等級(A,B,C,D,E,F)

//設計藍圖
//類別(屬性)只能在第一層定義，其他均為區域變數 Local variable
class Student(val id: String, val name: String,
                var english: Int, var math: Int) {

    //次要建構子是為了讓類別在某些情境上的使用，更能夠符合他們的需求
    //冒號後為回傳至主要建構子
    constructor(id: String, name: String) : this(id,name,0,0)
    fun print() {
        // /t 為定位點即空白
        println("$id\t$name\t$english\t$math")
    }
}

//演練實作程式
fun main() {
    var stu1 = Student("001", "Jack", 70, 80)
    var stu2 = Student("002", "Tetsu", 80, 90)
    var stu3 = Student("003", "Jane")
    stu1.print()
    stu2.print()
    stu3.print()
}