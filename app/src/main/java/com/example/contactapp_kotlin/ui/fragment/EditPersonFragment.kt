package com.example.contactapp_kotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.contactapp_kotlin.R
import com.example.contactapp_kotlin.databinding.FragmentEditPersonBinding
import com.example.contactapp_kotlin.ui.viewmodel.EditPersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class EditPersonFragment : Fragment() {

    private lateinit var binding: FragmentEditPersonBinding
    private lateinit var viewModel: EditPersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: EditPersonViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentEditPersonBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_person, container, false)

        val bundle: EditPersonFragmentArgs by navArgs()
        val person = bundle.person

        binding.person = person
//        binding.toolbarEdit.title = "Edit Person"
        binding.editPersonToolbar = "Edit Person"

        binding.textinputName.setText(person.name)
        binding.textinputTel.setText(person.tel)

        binding.buttonEdit.setOnClickListener {
            val name = binding.textinputName.text.toString()
            val tel = binding.textinputTel.text.toString()

            editPerson(name, tel)
        }

        return binding.root
    }

    private fun editPerson(name: String, tel: String) {
        viewModel.edit(name, tel)
    }
}