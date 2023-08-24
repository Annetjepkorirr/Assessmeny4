package com.example.myapplication.model

import androidx.room.PrimaryKey


data class post(
    var userId:String,
    var id:String,
    var title: String,
    var body: String,
)
