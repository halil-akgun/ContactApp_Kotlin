package com.example.contactapp_kotlin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactapp_kotlin.data.entity.Person
import com.example.contactapp_kotlin.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var personDaoRepository: PersonDaoRepository) :
    ViewModel() {
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