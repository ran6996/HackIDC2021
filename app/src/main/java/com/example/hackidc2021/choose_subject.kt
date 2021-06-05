package com.example.hackidc2021

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choose_subject.*


class choose_subject : AppCompatActivity() {

    init {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_subject)
        val personDetails: Person? = intent.extras!!.getParcelable("personDetails")
        val eventDetails: Event? = intent.extras!!.getParcelable("eventDetails")
        if (personDetails != null) {
            person_name_box.setText(personDetails.name)
        }
        button3.setOnClickListener{
            val intent = Intent(this, personal_details::class.java)
            intent.putExtra(PERSON, personDetails)
            intent.putExtra(EVENT, eventDetails)
            startActivity(intent)
        }

    }
}
