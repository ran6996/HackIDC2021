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
            private_name.setText(personDetails.name)
            last_name.setText(personDetails.lastName)
            tz.setText(personDetails.iD.toString())
            age.setText(personDetails.age)
            address.setText(personDetails.address)
            firm.setText(personDetails.vehicleModel)
            policy_num.setText(personDetails.policyNumber.toString())
            car_num.setText(personDetails.carId.toString())
            year.setText(personDetails.vehicleYear.toString())
            driver.setText(personDetails.isSingleDriver.toString())
        }
        button10.setOnClickListener{
            val intent = Intent(this, take_a_picture::class.java)
            intent.putExtra(PERSON, personDetails)
            intent.putExtra(EVENT, eventDetails)
            startActivity(intent)
        }
    }
}