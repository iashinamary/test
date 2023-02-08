package com.example.test_app.oneTimeWorkRequest

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.test_app.R
import com.example.test_app.repository.Repository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MyWorker(
    context: Context,
    params: WorkerParameters
): CoroutineWorker(context, params), KoinComponent {
    companion object {
        const val CHANNEL_ID = "channel_id"
        const val NOTIFICATION_ID = 1
    }

    private val repository: Repository by inject()

    private val notificationManager: NotificationManager = context.getSystemService(NotificationManager::class.java)



    override suspend fun doWork(): Result{
        return try {
            val notificationBuilder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
            val chosenItem = repository.getSelectedItem()
            chosenItem?.let { data ->
                notificationManager.notify(1,
                    notificationBuilder.setContentText(data.nom_zak).build()
                )

            }
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }

    }



}

