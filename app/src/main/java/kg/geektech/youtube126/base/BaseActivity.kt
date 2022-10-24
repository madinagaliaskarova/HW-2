package kg.geektech.youtube126.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(): VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        isConnection()
        initViews()
        initViewModel()
        initListener()

    }

    open fun initViews() {}
    open fun initListener() {}
    open fun initViewModel() {}
    open fun isConnection() {}


}

