package tw.com.donhi.bmi.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//DAO:Data Acess Object 資料存取物件(介面)
@Dao
interface RecordDao {
    //提供哪些功能讓使用者存取資料
    //新增資料
    @Insert(onConflict = OnConflictStrategy.REPLACE) //onConflict 避免衝突
    fun insert(record: Record)

    //讀取資料
    @Query("Select * from Record")
    fun getAll() : List<Record>
}