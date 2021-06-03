package com.example.hackidc2021

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.squareup.seismic.ShakeDetector


class ShakeDemo : Activity(), ShakeDetector.Listener {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sd = ShakeDetector(this)
        sd.start(sensorManager)
        finish()
    }

    override fun hearShake() {
        val speedNotif = SpeedNotification(this)
        speedNotif.showNotification()
    }
}
