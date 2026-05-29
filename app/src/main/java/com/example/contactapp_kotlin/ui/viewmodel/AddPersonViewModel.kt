package com.example.contactapp_kotlin.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactapp_kotlin.data.repo.PersonDaoRepository

class AddPersonViewModel : ViewModel() {
    private val personDaoRepository = PersonDaoRepository()

    fun add(name: String, tel: String) {
        personDaoRepository.addPerson(name, tel)
    }
}