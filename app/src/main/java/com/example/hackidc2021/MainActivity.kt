package com.example.hackidc2021

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val personDetails: Person
    val eventDetails: Event
    val insurType: Int

    init {
        personDetails = Person()
        eventDetails = Event()
        insurType = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Added for DB.
        val db = DatabaseHandler(this)

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..")
        db.addContact(PracticeClass(0, "Ravi", "9100000000"))
        db.addContact(PracticeClass(1, "Srinivas", "9199999999"))
        db.addContact(PracticeClass(2, "Tommy", "9522222222"))
        db.addContact(PracticeClass(3, "Karthik", "9533333333"))

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..")
        val contacts: List<PracticeClass> = db.allContacts
        for (cn in contacts) {
            val log = "Id: " + cn.iD.toString() + " ,Name: " + cn.name
                .toString() + " ,Phone: " +
                    cn.phoneNumber
            // Writing Contacts to log
            Log.d("Name: ", log)
        }
    }

    /**
     * gets a name and password, adds to PersonAndEvent all relevant fields if exsist. if no such
     * name or password - returns -1 (fail), else - returns success (0).
     */
    fun NameAndPassword(): Int
    {
        if (checkUseAndPasswordOnExcel() == -1)
        {
            print("The UserName or Password was incorrect")
            return -1
        }
        else
        {
            return 0
        }
    }

    /**
     * checks userName and password and if valid - populates the person part. return 0 on success.
     * if not valid - return -1
     */
    fun checkUseAndPasswordOnExcel() : Int
    {
        return 0
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
    fun FinnishProccess(): Int {
        return 0
    }

    /**
     * save temp info to phone so we can continue later.
     */
    fun saveTempToPhone(): Int {
        return 0
    }


    fun PhotoGetter() {}

    fun LocationGetter() {}

    fun MicrophoneGeter() {}

    fun MicrophoneToString() {}

    fun StringInputGetter(): String {
        return "A"; }

}

