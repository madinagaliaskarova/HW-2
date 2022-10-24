package kg.geektech.youtube126.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.view.isVisible
import kg.geektech.youtube126.base.BaseActivity
import kg.geektech.youtube126.databinding.ActivitySecondBinding
import kg.geektech.youtube126.ui.activity.MainActivity


class SecondActivity : BaseActivity<ActivitySecondBinding>() {

    override fun inflateViewBinding(): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getTextFromIntent()
        modifyButtonVisibilityIfTextIsEmpty()
        sendTextBack()
    }

    private fun sendTextBack() {
        binding.btnSec.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", binding.etSec.text.toString())
            setResult(Activity.RESULT_OK, intent)
            onBackPressed()
        }
    }

    private fun getTextFromIntent() {
        binding.etSec.setText(intent?.getStringExtra("item"))
    }

    private fun modifyButtonVisibilityIfTextIsEmpty() {
        binding.etSec.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnSec.isVisible = binding.etSec.text.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }
}