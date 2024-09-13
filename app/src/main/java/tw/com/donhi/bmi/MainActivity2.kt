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
    val serect = (1..10).random()

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
        Toast.makeText(this, "serect: $serect", Toast.LENGTH_LONG).show()
    }
    fun guess(view: View) {
        if (!binding.number.text.toString().equals("")) {
            val num = binding.number.text.toString().toInt()
            Log.d("MainActivity2", num.toString())
            val message = if (num > serect) {
                "Smaller"
            } else if (num < serect) {
                "Bigger"
            } else {
                "You got it!"
            }
            //建置對話框
            AlertDialog.Builder(this)
                .setTitle("Info")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
        } else {
            //顯示訊息框(Context=MainActivity,String=訊息,Length 長度)
            //Toast 顯示不重要的提示訊息
            Toast.makeText(this, "Please Enter a Number",
                Toast.LENGTH_LONG).show()
        }
    }
}