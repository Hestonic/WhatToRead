package com.example.pd.ui.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pd.App
import com.example.pd.databinding.FragmentRegistrationBinding
import com.example.pd.ui.fragments.authorization.AuthorizationViewModel
import com.example.pd.ui.fragments.authorization.AuthorizationViewModelFactory
import com.example.pd.ui.main.SessionManager

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var viewModel: RegistrationViewModel
    private lateinit var sessionManager: SessionManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
        initViewModel()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        binding.authorizationLabel.setOnClickListener {
            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToAuthorizationFragment())
        }
        
        

        return  binding.root
    }
    
    private fun initViewModel() {
        val authorizationRepository =
            (requireActivity().application as App).dependencyInjection.authorizationRepository
        val userRepository =
            (requireActivity().application as App).dependencyInjection.userRepository
        val viewModelFactory =
            RegistrationViewModelFactory(authorizationRepository, userRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[RegistrationViewModel::class.java]
    }

}