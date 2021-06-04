package com.example.hackidc2021

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class SpeedNotification(base: Context?) : ContextWrapper(base) {

    private val channelName: String = "HackIDC"
    private val channelID: String = "2021"
    private var notificationID: Int = 0
    private val channelDescription = "test description"
    private var notificationManager: NotificationManager? = null


    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = channelName
            val descriptionText = channelDescription
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager!!.createNotificationChannel(channel)
        }
    }

    val intent = Intent(applicationContext, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

    var builder = NotificationCompat.Builder(this, channelID)
        .setSmallIcon(android.R.drawable.ic_dialog_alert)
        .setContentTitle("שינוי מהירות")
        .setContentText("?הרגשנו שעצרת בבום! הכל בסדר")
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText("?הרגשנו שעצרת בבום! הכל בסדר")
        )
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        // Set the intent that will fire when the user taps the notification
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .setChannelId(channelID)


    fun showNotification() {
        createNotificationChannel()
        notificationID++
        with(NotificationManagerCompat.from(this)) {
            notify(notificationID, builder.build())
        }
    }
}
