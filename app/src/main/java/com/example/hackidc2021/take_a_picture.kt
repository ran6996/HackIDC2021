package com.example.hackidc2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hackidc2021.CameraUsage.TakePicture
import com.example.hackidc2021.ImageUpload.Upload

class take_a_picture : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_apicture)
    }

    fun PhotoGetter(v: View?) {
        val intent = Intent(this, Upload::class.java)
        startActivity(intent)
        // Start the activity to upload an image
    }

    fun TakePhoto(v: View?) {
        val intent = Intent(this, TakePicture::class.java)
        startActivity(intent)
        // Start the activity to upload an image
    }
}