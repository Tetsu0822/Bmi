package tw.com.donhi.bmi.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@annotation標示,編譯時期處理功能
@Entity
class Record(
    @NonNull //標示不能為null
    //@ColumnInfo欄位資訊補充
    @ColumnInfo(name = "nick")
    var nickname:String,
    var counter:Int,
    @PrimaryKey(autoGenerate = true) //主鍵(自動產生)
    var id:Long = 0
    ) {
}