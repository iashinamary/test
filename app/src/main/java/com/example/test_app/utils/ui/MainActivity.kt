package com.example.test_app.utils.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_app.databinding.MainActivityLayoutBinding

class MainActivity: AppCompatActivity() {

    private lateinit var binding: MainActivityLayoutBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }




}