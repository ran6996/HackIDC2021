package com.example.hackidc2021

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.icu.util.UniversalTimeScale.toLong
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.speech.RecognizerIntent
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

import com.example.hackidc2021.CameraUsage.TakePicture
import com.example.hackidc2021.ImageUpload.Upload

import kotlinx.android.synthetic.main.activity_main.*
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.util.*


const val PERSON = "personDetails"
const val EVENT = "eventDetails"

class MainActivity : AppCompatActivity() {

    val personDetails: Person
    val eventDetails: Event
    val insurType: Int
    val secondActivity: choose_subject

    init {
        personDetails = Person()
        eventDetails = Event()
        insurType = 0
        secondActivity = choose_subject()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Added for DB.
        val db = DatabaseHandler(this)

        // Inserting Contact
        Log.d("Insert: ", "Inserting ..")
        db.addContact(personDetails)

        // Insert login info.
        button.setOnClickListener {
            personDetails.username = editTextTextPersonName.text.toString()
            personDetails.password = editTextTextPassword.text.toString()
            Login()
        }

        // Push notification following 3 shakes.
        startActivity(Intent(this, ShakeDemo::class.java))

    }



    /**
     * gets a name and password, adds to PersonAndEvent all relevant fields if exist. if no such
     * name or password - returns -1 (fail), else - returns success (0).
     */
    fun Login() {
        if (checkLoginInfo() == -1) {
            print("The userName or password was incorrect.")
            return
        } else {
            val intent = Intent(this, choose_subject::class.java)
            intent.putExtra(PERSON, personDetails)
            intent.putExtra(EVENT, eventDetails)
            startActivity(intent)
        }
    }

    /**
     * checks userName and password and if valid - populates the person part. return 0 on success.
     * if not valid - return -1
     */
    fun checkLoginInfo(): Int {
        val bufferedReader = BufferedReader(InputStreamReader(assets.open("users.txt")))

        val csvParser = CSVParser(
            bufferedReader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
        )

        for (csvRecord in csvParser) {
            val user = csvRecord.get("username")
            val pswd = csvRecord.get("password")
            if (personDetails.username == user && personDetails.password == pswd) {
                personDetails.name = csvRecord.get("first")
                personDetails.iD = csvRecord.get("id").toLong()
                personDetails.lastName = csvRecord.get("last")
                personDetails.phoneNumber = csvRecord.get("phone").toLong()
                personDetails.email = csvRecord.get("email")
                personDetails.age = csvRecord.get("age")
                personDetails.isSingleDriver = csvRecord.get("single_driver") == "Yes"
                personDetails.policyType = csvRecord.get("policy_type")
                personDetails.address = csvRecord.get("address")
                personDetails.policyNumber = csvRecord.get("policyNumber").toLong()
                personDetails.vehicleYear = csvRecord.get("vehicleYear").toLong()
                personDetails.vehicleModel = csvRecord.get("vehicleModel")
                personDetails.carId = csvRecord.get("carId").toLong()
                return 0
            }
        }
        return -1
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

