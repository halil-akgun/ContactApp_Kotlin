package com.example.contactapp_kotlin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactapp_kotlin.data.entity.Person
import com.example.contactapp_kotlin.data.repo.PersonDaoRepository

class HomepageViewModel : ViewModel() {
    private val personDaoRepository = PersonDaoRepository()
    var personListLiveData: MutableLiveData<List<Person>> = MutableLiveData()

    init {
        loadAllPerson()
        personListLiveData = personDaoRepository.getPersonList()
    }

    fun search(query: String) {
        personDaoRepository.searchPerson(query)
    }

    fun delete(id: Int) {
        personDaoRepository.deletePerson(id)
    }

    fun loadAllPerson() {
        personDaoRepository.getAllPerson()
    }
}