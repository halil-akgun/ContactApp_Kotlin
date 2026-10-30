package com.example.contactapp_kotlin.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactapp_kotlin.data.entity.Person

@Database(entities = [Person::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getAll(): PersonDao
}