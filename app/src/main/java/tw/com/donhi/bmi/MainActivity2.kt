package tw.com.donhi.bmi

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import tw.com.donhi.bmi.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
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
        //GuessGame 取值
        //Toast.makeText(this, "serect: $serect", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "serect: ${game.secret}", Toast.LENGTH_LONG).show()
    }
    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            val num = binding.number.text.toString().toInt()
            val message = when(game.guess(num)) {
                GuessGame.Status.SMALLER -> getString(R.string.smaller)
                GuessGame.Status.BIGGER -> getString(R.string.bigger)
                else -> getString(R.string.you_got_it)
            }
            //將counter更新至畫面
            binding.counter.text = game.counter.toString()
            //建置對話框
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.info))
                .setMessage(message)
                .setPositiveButton(getString(R.string.OK), null)
                .show()
        } else {
            //顯示訊息框(Context=MainActivity,String=訊息,Length 長度)
            //Toast 顯示不重要的提示訊息
            Toast.makeText(this, getString(R.string.please_enter_a_number),
                Toast.LENGTH_LONG).show()
        }
    }
}