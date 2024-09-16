package tw.com.donhi.bmi

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import tw.com.donhi.bmi.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewModel: GuessViewModel
    //MainActivity2 使用簡易名稱
    val TAG = MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    //val serect = (1..10).random() 已放入GuessGame類跌
    val game = GuessGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
        viewModel.counter.observe(this, { counter ->
            binding.counter.text = counter.toString()
        })
        viewModel.status.observe(this, { status ->
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
                    //Lambda 寫法
                    .setNegativeButton("Relay", { dialog, which ->
                        Log.d(TAG, "Replay")
                        viewModel.reset()
                    })
                    .show()
            }
        })
        //GuessGame 取值
        //Toast.makeText(this, "serect: $serect", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "serect: ${game.secret}", Toast.LENGTH_LONG).show()
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
}