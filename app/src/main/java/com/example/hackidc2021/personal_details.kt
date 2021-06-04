package com.example.hackidc2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose_subject.*
import kotlinx.android.synthetic.main.activity_personal_details.*

class personal_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_details)

        val personDetails: Person? = intent.extras!!.getParcelable("personDetails")
        val eventDetails: Event? = intent.extras!!.getParcelable("eventDetails")
        if (personDetails != null) {
            private_name.text = personDetails.name
            last_name.text = personDetails.lastName
            tz.text = personDetails.iD.toString()
            age.text = personDetails.age
            address.text = personDetails.address
            firm.text = personDetails.vehicleModel
            policy_num.text = personDetails.policyNumber.toString()
            car_num.text = personDetails.carId.toString()
            year.text = personDetails.vehicleYear.toString()
            driver.text = personDetails.isSingleDriver.toString()
        }
        button10.setOnClickListener{
            val intent = Intent(this, take_a_picture::class.java)
            intent.putExtra(PERSON, personDetails)
            intent.putExtra(EVENT, eventDetails)
            startActivity(intent)
        }
    }
}