package com.example.contactapp_kotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.contactapp_kotlin.R
import com.example.contactapp_kotlin.databinding.FragmentAddPersonBinding
import com.example.contactapp_kotlin.ui.viewmodel.AddPersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class AddPersonFragment : Fragment() {

    private lateinit var binding: FragmentAddPersonBinding
    private lateinit var viewModel: AddPersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddPersonViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentAddPersonBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_person, container, false)

//        binding.toolbarAdd.title = "Add Person"
        binding.addPersonToolbar = "Add Person"

        binding.buttonAdd.setOnClickListener {
            val name = binding.textinputName.text.toString()
            val tel = binding.textinputTel.text.toString()

            btnAddPerson(name, tel)
        }

        return binding.root
    }

    fun btnAddPerson(name: String, tel: String) {
        viewModel.add(name, tel)
    }
}