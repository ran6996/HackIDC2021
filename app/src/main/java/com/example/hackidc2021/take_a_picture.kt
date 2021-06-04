package com.example.hackidc2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hackidc2021.CameraUsage.TakePicture
import com.example.hackidc2021.ImageUpload.Upload
import kotlinx.android.synthetic.main.activity_take_apicture.*

class take_a_picture : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_apicture)

        button2.setOnClickListener{
            val intent = Intent(this, recorder::class.java)
//            intent.putExtra(PERSON, personDetails)
//            intent.putExtra(EVENT, eventDetails)
            startActivity(intent)
        }
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