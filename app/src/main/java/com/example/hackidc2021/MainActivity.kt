package com.example.hackidc2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val details : Person

    init
    {
        details = Person()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * gets a name and password, adds to PersonAndEvent all relevant fields if exsist. if no such
     * name or password - returns -1 (fail), else - returns success (0).
     */
    fun NameAndPassword(name: String, password: String): Int
    {
        return 0
    }

    fun InshurenceType(type: String): Int
    {
        return 0
    }

}