package com.example.contactapp_kotlin.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactapp_kotlin.data.entity.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    suspend fun getAll(): List<Person>

    @Query("SELECT * FROM person WHERE id = :id")
    suspend fun get(id: Int): Person

    @Query("SELECT * FROM person WHERE name LIKE '%' || :query || '%'")
    suspend fun filter(query: String): List<Person>

    @Insert
    suspend fun insert(person: Person)

    @Update
    suspend fun update(person: Person)

    @Delete
    suspend fun delete(person: Person)
}