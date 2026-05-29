package com.example.contactapp_kotlin.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactapp_kotlin.data.repo.PersonDaoRepository

class EditPersonViewModel : ViewModel() {
    private val personDaoRepository = PersonDaoRepository()

    fun edit(name: String, tel: String) {
        personDaoRepository.editPerson(name, tel)
    }
}