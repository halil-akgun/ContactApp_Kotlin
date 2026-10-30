package com.example.contactapp_kotlin.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactapp_kotlin.data.entity.Person
import com.example.contactapp_kotlin.data.room.PersonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDaoRepository(private var personDao: PersonDao) {
    var personListLiveData: MutableLiveData<List<Person>> = MutableLiveData()

    fun getPersonList(): MutableLiveData<List<Person>> {
        return personListLiveData
    }

    fun addPerson(name: String, tel: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val person = Person(0, name, tel)
            personDao.insert(person)
        }
    }

    fun editPerson(id: Int, name: String, tel: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val person = Person(id, name, tel)
            personDao.update(person)
        }
    }

    fun searchPerson(query: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personListLiveData.value = personDao.filter(query)
        }
    }

    fun deletePerson(id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val person = Person(id, "", "")
            personDao.delete(person)
            getAllPerson()
        }
    }

    fun getAllPerson() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personListLiveData.value = personDao.getAll()
        }
    }
}