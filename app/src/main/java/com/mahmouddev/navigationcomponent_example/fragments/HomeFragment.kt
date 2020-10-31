package com.mahmouddev.navigationcomponent_example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mahmouddev.navigationcomponent_example.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val action  = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(name)
            findNavController().navigate(action)
        }
    }

}