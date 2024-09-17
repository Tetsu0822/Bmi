package tw.com.donhi.bmi.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

//資料(抽象)類別
@Database(entities = arrayOf(Record::class), version = 1)
abstract class GameDataBase : RoomDatabase() {
    //抽象方法回傳RecordDao
    abstract fun recordDao():RecordDao
}