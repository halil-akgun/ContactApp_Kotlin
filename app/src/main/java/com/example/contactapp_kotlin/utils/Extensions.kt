package com.example.contactapp_kotlin.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.contactapp_kotlin.R
import androidx.navigation.findNavController

fun Navigation.switch(it: View, id: Int) {
//    findNavController(it).navigate(R.id.action_homepageFragment_to_addPersonFragment)
    it.findNavController().navigate(R.id.action_homepageFragment_to_addPersonFragment)
}

fun Navigation.switch(it: View, action: NavDirections) {
//    findNavController(it).navigate(action)
    it.findNavController().navigate(action)
}