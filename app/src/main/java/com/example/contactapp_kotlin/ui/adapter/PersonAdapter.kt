package com.example.contactapp_kotlin.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp_kotlin.data.entity.Person
import com.example.contactapp_kotlin.databinding.CardBinding
import com.example.contactapp_kotlin.ui.fragment.HomepageFragmentDirections
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import com.example.contactapp_kotlin.R
import com.example.contactapp_kotlin.ui.viewmodel.HomepageViewModel

class PersonAdapter(
    var mContext: Context,
    var personList: List<Person>,
    var viewModel: HomepageViewModel
) :
    RecyclerView.Adapter<PersonAdapter.CardViewHolder>() {

    inner class CardViewHolder(view: CardBinding) : RecyclerView.ViewHolder(view.root) {
        var binding: CardBinding = view
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
//        val binding = CardBinding.inflate(layoutInflater, parent, false)
        val binding: CardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CardViewHolder,
        position: Int
    ) {
        val person = personList[position]
        val binding = holder.binding
//        binding.textViewPersonInfo.text = "${person.name} - ${person.tel}"
        binding.person = person

        binding.cardRow.setOnClickListener {
            // data transfer
            val action =
                HomepageFragmentDirections.actionHomepageFragmentToEditPersonFragment(person = person)
            it.findNavController().navigate(action)
        }

        binding.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "Delete person? : ${person.name}", Snackbar.LENGTH_LONG)
                .setAction("Delete") {
                    viewModel.delete(person.id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}