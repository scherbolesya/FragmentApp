package com.olesya.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.olesya.fragmentapp.R.layout.fragment_about

class AboutFragment : Fragment() {

    private lateinit var backButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(fragment_about, container, false)
        backButton = view.findViewById(R.id.back_button)

        val menuFragment = MenuFragment()
        backButton.setOnClickListener {

            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, menuFragment)
                ?.commit()
        }

        return view
    }
}

