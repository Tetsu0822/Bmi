package tw.com.donhi.bmi

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import tw.com.donhi.bmi.data.GameDataBase
import tw.com.donhi.bmi.data.Record
import tw.com.donhi.bmi.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private val NICKNAME_REQ: Int = 11
    private lateinit var viewModel: GuessViewModel
    //MainActivity2 使用簡易名稱
    val TAG = MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    //val serect = (1..10).random() 已放入GuessGame類跌
    val game = GuessGame()
    //訂定Activity Result合約
    val requestNickName = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val nickname = getSharedPreferences("guess", MODE_PRIVATE)
            .getString("nickname", null)
        Log.d(TAG, "Data: $nickname")
        if (result.resultCode == RESULT_OK) {
            val nickname = result.data?.getStringExtra("NICK")
            Log.d(TAG, "Result: $nickname")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d(TAG, "onCreate: ")
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //建立ViewModel物件，此物件只存活在onCreate()
        viewModel = ViewModelProvider(this).get(GuessViewModel::class.java)
        //使用LiveData的observe方法(介面)觀察畫面counter變動
        viewModel.counter.observe(this) { counter ->
            binding.counter.text = counter.toString()
        }
        viewModel.status.observe(this) { status ->
            val message = when(status) {
                GameStatus.BIGGER -> getString(R.string.bigger)
                GameStatus.SMALLER -> getString(R.string.smaller)
                GameStatus.INIT -> ""
                else -> getString(R.string.you_got_it)
            }
            if (status != GameStatus.INIT) {
                //建置對話框
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.info))
                    .setMessage(message)
                    .setPositiveButton(getString(R.string.OK), null)
                    //Lambda 原始寫法
//                    .setNegativeButton("Relay", { dialog, which ->
//                        Log.d(TAG, "Replay")
//                        viewModel.reset()
//                    })
                    //若Lambda 為最後的設定則可將其移出小括弧()
                    .setNegativeButton("Relay") { dialog, which ->
                        Log.d(TAG, "Replay")
                        viewModel.reset()
                    }
                    .show()
            }
        }
        viewModel.serectData.observe(this) { serect ->
            //GuessGame 取值
            //Toast.makeText(this, "serect: $serect", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "serect: $serect", Toast.LENGTH_LONG).show()
        }
        //Room Test
        val database = Room.databaseBuilder(this,
            GameDataBase::class.java, "game.db")
            .build()
        val record = Record("Jack", 3)
        //主執行緒不能直接執行負荷較重的程式，需產生另外的執行緒來執行
        //使用Kotlin Coroutines協同,或Java的執行緒Thread
        Thread() {
            //寫入資料
            //database.recordDao().insert(record)
            //讀取列出資料
            val list = database.recordDao().getAll()
            for (r in list) {
                Log.d(TAG, "onCreate: ${r.nickname}")
            }
        }.start()
    }
    fun guess(view: View) {
        viewModel.guess(binding.number.text.toString().toInt())
        /*
        if (!binding.number.text.toString().equals("")) {
            val num = binding.number.text.toString().toInt()
            val message = when(game.guess(num)) {
                GuessGame.Status.SMALLER -> getString(R.string.smaller)
                GuessGame.Status.BIGGER -> getString(R.string.bigger)
                else -> getString(R.string.you_got_it)
            }
            //將counter更新至畫面
            binding.counter.text = game.counter.toString()
            //監聽
            val okListener = object : OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("Not yet implemented")
                }
            }
            //建置對話框
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info))
                .setMessage(message)
                .setPositiveButton(getString(R.string.OK), null)
                //Lambda 寫法
                .setNegativeButton("Relay", { dialog, which ->
                    Log.d(TAG, "Replay")
                    game.reset()
                    binding.counter.text = game.counter.toString()
                })
                .show()
        } else {
            //顯示訊息框(Context=MainActivity,String=訊息,Length 長度)
            //Toast 顯示不重要的提示訊息
            Toast.makeText(this, getString(R.string.please_enter_a_number),
                Toast.LENGTH_LONG).show()
        }
         */
    }

    fun setNickName(view: View) {
        //Intent意圖,1.顯性意圖 Explicit,2.隱性意圖 Implicict
        val intent = Intent(this, NickNameActivity::class.java)
        //傳送資料到新的畫面
        intent.putExtra("EXTRAS_LEVEL", 3)
        intent.putExtra("NAME", "Tetsu")
        //送到Android系統才會到清單內找到此Activity，然後顯示在畫面上
        //startActivity 僅切換畫面
//        startActivity(intent)
        //取得另一畫面的回傳值,自動複寫onActivityResult
        //已棄用，由Activity Result API 取代
        //startActivityForResult(intent, NICKNAME_REQ)
        requestNickName.launch(intent)
        //Kotlin寫法,Scope Functions
        Intent(this, NickNameActivity::class.java).apply {
            putExtra("A", "ABC")
            putExtra("B", "Testing")
        }.also {
            requestNickName.launch(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NICKNAME_REQ) {
            Log.d(TAG, "onActivityResult: $resultCode")
            val nickname = data?.getStringExtra("NICK")
            Log.d(TAG, "onActivityResult: $nickname")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }
}