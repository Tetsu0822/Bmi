package tw.com.donhi.bmi

//作業 猜數字
fun main() {
    val secret = 7
    var num = 0
    var s = 1
    var b = 10

    while (num != secret) {
        print("Please enter a number($s-$b): ")
        var input = readLine()
        num = input?.toIntOrNull() ?: 0

        if (num < secret) {
            if (num >= s) {
                s = num
            }
        } else if (num > secret) {
            if (num <= b) {
                b = num
            }
        }else {
            println("You got it!")
            break
        }
    }
}