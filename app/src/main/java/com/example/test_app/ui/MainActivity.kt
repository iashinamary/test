package com.example.test_app.ui

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.test_app.broadcastReceiver.MyBroadcastReceiver
import com.example.test_app.databinding.MainActivityLayoutBinding
import com.example.test_app.oneTimeWorkRequest.MyWorker
import com.example.test_app.ui.adapter.ScreenAdapter
import com.example.test_app.ui.adapter.ScreenViewHolder
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit
import java.util.jar.Manifest

class MainActivity: AppCompatActivity() {

    private lateinit var binding: MainActivityLayoutBinding

    private val viewModel by viewModel<MainActivityViewModel>()

    private val adapter : ScreenAdapter by lazy { ScreenAdapter()}

    private val receiver by lazy { MyBroadcastReceiver() }


    var counterCopies = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribe()
        viewModel.loadData()
        clickButton()
        this.registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    private fun clickButton() {
        val workRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .setInitialDelay(10, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(this).enqueue(workRequest)
        binding.apply {
            elements.adapter = adapter
            adapter.bindOnClick { item->
                viewModel.saveChecked(item)
            }

            addToBottom.setOnClickListener {
                counterCopies++
                counter.text = counterCopies.toString()
                viewModel.addBottomCopy()
            }
            addToTop.setOnClickListener{
                counterCopies++
                counter.text = counterCopies.toString()
                viewModel.addTopCopy()
            }
        }
    }

    private fun subscribe() {
        viewModel.data.observe(this){
            adapter.setList(it)

        }
    }





}