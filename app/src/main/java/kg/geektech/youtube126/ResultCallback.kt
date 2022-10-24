package kg.geektech.youtube126

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import kg.geektech.youtube126.ui.activity.SecondActivity

class ResultCallback : ActivityResultContract<String, String>() {

    override fun createIntent(context: Context, input: String): Intent =
        Intent(context, SecondActivity::class.java).apply {
            putExtra("item", input)
        }

    override fun parseResult(resultCode: Int, intent: Intent?) =
        intent?.getStringExtra("key").toString()
}