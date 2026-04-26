package com.example.contactapp_kotlin.data.entity

import java.io.Serializable

data class Person(
    var id: Int,
    var name: String,
    var tel: String
) : Serializable