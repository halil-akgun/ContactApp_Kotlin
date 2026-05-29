package com.example.contactapp_kotlin.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactapp_kotlin.data.entity.Person

class PersonDaoRepository {
    var personListLiveData: MutableLiveData<List<Person>> = MutableLiveData()

    fun getPersonList(): MutableLiveData<List<Person>> {
        return personListLiveData
    }

    fun addPerson(name: String, tel: String) {
        Log.d("AddPersonFragment", "name: $name, tel: $tel")
    }

    fun editPerson(name: String, tel: String) {
        Log.d("EditPersonFragment", "name: $name, tel: $tel")
    }

    fun searchPerson(query: String) {
        Log.d("HomepageFragment", "query: $query")
    }

    fun deletePerson(id: Int) {
        Log.d("HomepageFragment", "id: $id")
    }

    fun getAllPerson() {
        val personList = ArrayList<Person>()
        personList.add(Person(1, "John Doe", "1234567890"))
        personList.add(Person(2, "Jane Doe", "0987654321"))
        personListLiveData.value = personList
    }
}