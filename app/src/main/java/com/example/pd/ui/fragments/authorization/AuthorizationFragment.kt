package com.example.pd.ui.fragments.authorization

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pd.data.api.RetrofitInstance
import com.example.pd.data.repository.AuthorizationRepositoryImpl
import com.example.pd.databinding.FragmentAuthorizationBinding
import com.example.pd.utils.SessionManager

class AuthorizationFragment : Fragment() {
    
    private lateinit var binding: FragmentAuthorizationBinding
    private lateinit var viewModel: AuthorizationViewModel
//    private val sessionManager = SessionManager(requireContext())
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        
        binding.registrationLabel.setOnClickListener {
            findNavController().navigate(AuthorizationFragmentDirections.actionAuthorizationFragmentToRegistrationFragment())
        }
        
        binding.authorizationButton.setOnClickListener {
            val login = binding.editLogin.text.toString()
            val password = binding.editPassword.text.toString()
            if (login.isNotEmpty() && password.isNotEmpty()) viewModel.login(login, password)
            else Toast.makeText(requireContext(), "Не все поля заполнены", Toast.LENGTH_LONG)
        }
        
        viewModel.authorizationToken.observe(viewLifecycleOwner) {
            Log.d("authTokenTag", it)
//            sessionManager.saveAuthToken(it)
        }
        
        return binding.root
    }
    
    private fun initViewModel() {
        val authorizationRepository = AuthorizationRepositoryImpl(RetrofitInstance.remoteDataSource)
        val viewModelFactory = AuthorizationViewModelFactory(authorizationRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[AuthorizationViewModel::class.java]
    }
    
}