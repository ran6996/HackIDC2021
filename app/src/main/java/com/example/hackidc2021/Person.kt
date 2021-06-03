package com.example.hackidc2021

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Person
    (
    var iD: Long = 0,
    var username: String? = null,
    var password: String? = null,
    var name: String? = null,
    var phoneNumber: String? = null
) : Parcelable

//    constructor() {}
//    constructor(id: Long, name: String?, _phone_number: String?) {
//        iD = id
//        this.name = name
//        phoneNumber = _phone_number
//    }
//
//    constructor(parcel: Parcel) : this() {
//        username = parcel.readString()
//        password = parcel.readString()
//        iD = parcel.readLong()
//        name = parcel.readString()
//        phoneNumber = parcel.readString()
//    }
//
//
//    constructor(name: String?, _phone_number: String?) {
//        this.name = name
//        phoneNumber = _phone_number
//    }

