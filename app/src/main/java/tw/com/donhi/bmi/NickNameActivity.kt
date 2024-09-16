package tw.com.donhi.bmi

import android.icu.text.DateTimePatternGenerator.PatternInfo.OK
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import tw.com.donhi.bmi.databinding.ActivityNickNameBinding

class NickNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNickNameBinding
    val TAG = NickNameActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNickNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val level = intent.getIntExtra("EXTRAS_LEVEL", 0)
        val name = intent.getStringExtra("NAME")
        Log.d(TAG, "onCreate: $level $name")
    }

    fun save(view: View) {
        val nickname = binding.edNickName.text.toString()
        //設定回傳值
        setResult(RESULT_OK, intent.putExtra("NICK",nickname))
        //結束此方法
        finish()
    }
}