package com.example.test_app.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast

class MyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        when(intent?.action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)
                if (isAirplaneModeEnabled) {
                    Toast.makeText(context, "Airplane mode enabled", Toast.LENGTH_LONG).show()
                } else Toast.makeText(context, "Airplane mode disabled", Toast.LENGTH_LONG).show()
            }
        }
    }
}