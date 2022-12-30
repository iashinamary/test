package com.example.test_app.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast

class MyBroadcastReceiver(): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false)
        when(intent?.action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_LONG).show()
        }
    }
}