package com.example.test_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.test_app.databinding.MainActivityLayoutBinding
import com.example.test_app.ui.adapter.ScreenAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {

    private lateinit var binding: MainActivityLayoutBinding

    private val viewModel by viewModel<MainActivityViewModel>()

    private val adapter : ScreenAdapter by lazy { ScreenAdapter() }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.loadData()
        subscribe()
    }

    private fun subscribe() {
        viewModel.data.observe(this){
            adapter.setList(it)
        }
    }


}