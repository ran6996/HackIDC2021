package com.example.hackidc2021

class Person
{
    var username: String? = null
    var password: String? = null
    var iD: Long = 0
    var name: String? = null
    var password: String? = null
    var phoneNumber: String? = null

    constructor() {}
    constructor(id: Long, name: String?, _phone_number: String?) {
        iD = id
        this.name = name
        phoneNumber = _phone_number
    }

    constructor(name: String?, _phone_number: String?) {
        this.name = name
        phoneNumber = _phone_number
    }

}