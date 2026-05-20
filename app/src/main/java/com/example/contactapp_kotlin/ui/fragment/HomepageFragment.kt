package com.example.contactapp_kotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import com.example.contactapp_kotlin.databinding.FragmentHomepageBinding
import com.example.contactapp_kotlin.R
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp_kotlin.data.entity.Person
import com.example.contactapp_kotlin.ui.adapter.PersonAdapter

class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHomepageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)

//        binding.toolbarHome.title = "Contacts"
        binding.homeToolbar = "Contacts"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)

//        binding.rv.layoutManager = LinearLayoutManager(requireContext()) // done in xml
        val personList = ArrayList<Person>()
        personList.add(Person(1, "John Doe", "1234567890"))
        personList.add(Person(2, "Jane Doe", "0987654321"))

        val adapter = PersonAdapter(requireContext(), personList)
//        binding.rv.adapter = adapter
        binding.personAdapter = adapter

        binding.fabAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_homepageFragment_to_addPersonFragment)
        }

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val searchItem = menu.findItem(R.id.action_search)
                val searchView = searchItem.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomepageFragment)
            }

            override fun onMenuItemSelected(p0: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(query: String): Boolean {
        search(query)
        return true
    }

    fun search(query: String) {
        Log.d("HomepageFragment", "query: $query")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomepageFragment", "onResume")
    }
}