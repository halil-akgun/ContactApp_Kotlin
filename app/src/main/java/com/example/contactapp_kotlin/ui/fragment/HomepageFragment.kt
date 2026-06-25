package com.example.contactapp_kotlin.ui.fragment

import android.os.Bundle
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
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.contactapp_kotlin.databinding.FragmentHomepageBinding
import com.example.contactapp_kotlin.R
import androidx.navigation.findNavController
import com.example.contactapp_kotlin.ui.adapter.PersonAdapter
import com.example.contactapp_kotlin.ui.viewmodel.HomepageViewModel
import com.example.contactapp_kotlin.utils.switch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

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

        viewModel.personListLiveData.observe(viewLifecycleOwner) {
            val adapter = PersonAdapter(requireContext(), it, viewModel)
//        binding.rv.adapter = adapter
            binding.personAdapter = adapter
        }

        binding.fabAdd.setOnClickListener {
//            it.findNavController().navigate(R.id.action_homepageFragment_to_addPersonFragment)
            Navigation.switch(it, R.id.action_homepageFragment_to_addPersonFragment)
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
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAllPerson()
    }
}