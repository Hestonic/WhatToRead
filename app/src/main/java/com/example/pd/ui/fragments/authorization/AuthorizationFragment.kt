package com.example.pd.ui.fragments.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pd.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAuthorizationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)

        binding.registrationLabel.setOnClickListener {
            findNavController().navigate(AuthorizationFragmentDirections.actionAuthorizationFragmentToRegistrationFragment())
        }
        return binding.root
    }

}