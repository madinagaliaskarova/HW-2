package kg.geektech.youtube126.ui.activity

import android.os.Bundle
import android.widget.Toast
import kg.geektech.youtube126.ResultCallback
import kg.geektech.youtube126.base.BaseActivity
import kg.geektech.youtube126.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val getContent = registerForActivityResult(ResultCallback()) { returnedData: String ->
        binding.etFirst.setText(returnedData)
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendText()
    }

    private fun sendText() {
        binding.btnFirst.setOnClickListener {
            if (binding.etFirst.text.isEmpty()) {
                Toast.makeText(this, "Не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                getContent.launch(binding.etFirst.text.toString())
            }
        }
    }
}
