package com.example.contactapp_kotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactapp_kotlin.databinding.FragmentAddPersonBinding

class AddPersonFragment : Fragment() {

    private lateinit var binding: FragmentAddPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPersonBinding.inflate(inflater, container, false)

        binding.toolbarAdd.title = "Add Person"

        binding.buttonAdd.setOnClickListener {
            val name = binding.textinputName.text.toString()
            val tel = binding.textinputTel.text.toString()

            addPerson(name, tel)
        }

        return binding.root
    }

    fun addPerson(name: String, tel: String) {
        Log.d("AddPersonFragment", "name: $name, tel: $tel")
    }
}