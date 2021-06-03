package com.example.hackidc2021

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.example.hackidc2021.CameraUsage.TakePicture
import com.example.hackidc2021.ImageUpload.Upload

import kotlinx.android.synthetic.main.activity_main.*
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.InputStreamReader



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

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..")
        db.addContact(Person(0, "Ravi", "9100000000"))
        db.addContact(Person(1, "Srinivas", "9199999999"))
        db.addContact(Person(2, "Tommy", "9522222222"))
        db.addContact(Person(3, "Karthik", "9533333333"))

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..")
        val contacts: List<Person> = db.allContacts
        for (cn in contacts) {
            val log = "Id: " + cn.iD.toString() + " ,Name: " + cn.name
                .toString() + " ,Phone: " +
                    cn.phoneNumber
            // Writing Contacts to log
            Log.d("Name: ", log)
        }

        button.setOnClickListener{
            personDetails.username = editTextTextPersonName.text.toString()
            personDetails.password = editTextTextPassword.text.toString()
            Login()
        }
       // checkLoginInfo()
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
            if (personDetails.username == user && personDetails.password == pswd){
                personDetails.name = csvRecord.get("first")
                return 0
            }
        }
        return -1
    }

    /**
     * updates insurType to the relevant one and return 0 on success -1 on failure.
     */
    fun InsuranceType(type: String): Int {
        return 0
    }

    /**
     * check who drove and adds it to the event instance. fills up the driver info accordingly
     * returns 0 on success.
     */
    fun didTheOnerDrive(): Int {
        return 0
    }

    /**
     * desplays info generated form the Person and Event objects. gets input from user
     * for specific fields and updates the person & event instances accordingly.
     * personal info as: name, id, etc event info as driver, num of vehicle etc.
     */
    fun Info(): Int {
        return 0
    }

    /**
     * gets AccidentInfo and save in the event, gets pics, voice description etc.
     * In here we may add a check if the pics are from the internet, if the ID on the car matches,
     * if the car color and photos we have are matching the color and type in the photos we get.
     * Location of the accident - will get from phone here.
     */
    fun AccidentInfo(): Int {
        return 0
    }

    /**
     * success if success in the end and send file / data to company.
     */
    fun FinishProccess(): Int {
        return 0
    }

    /**
     * save temp info to phone so we can continue later.
     */
    fun saveTempToPhone(): Int {
        return 0
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

    fun LocationGetter() {}

    fun MicrophoneGeter() {}

    fun MicrophoneToString() {}

    fun StringInputGetter(): String {
        return "A"; }

}

