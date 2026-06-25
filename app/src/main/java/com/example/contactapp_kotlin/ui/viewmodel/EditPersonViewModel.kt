package com.example.contactapp_kotlin.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactapp_kotlin.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditPersonViewModel @Inject constructor(var personDaoRepository: PersonDaoRepository) :
    ViewModel() {
    fun edit(name: String, tel: String) {
        personDaoRepository.editPerson(name, tel)
    }
}