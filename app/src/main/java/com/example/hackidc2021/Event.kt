package com.example.hackidc2021

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Event (
    var carId: Long = 0
        ) : Parcelable
