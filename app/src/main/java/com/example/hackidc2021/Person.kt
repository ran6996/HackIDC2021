package com.example.hackidc2021

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Driver

@Parcelize
class Person
    (
    var iD: Long = 0,
    var username: String? = null,
    var password: String? = null,
    var name: String? = null,
    var lastName: String? = null,
    var phoneNumber : Long = 0,
    var email: String? = null,
    var age: String? = null,
    var isSingleDriver: Boolean? = null,
    var policyType: String? = null,
    var address: String? = null,
    var policyNumber : Long = 0,
    var vehicleYear: Long = 0,
    var vehicleModel: String? = null,
    var carId: Long = 0
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

