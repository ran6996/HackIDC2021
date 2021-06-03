package com.example.hackidc2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_choose_subject.*


class choose_subject : AppCompatActivity() {

    init {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_subject)
        person_name_box.setText(person.name)

    }
}
