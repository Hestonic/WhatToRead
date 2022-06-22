package com.example.pd.ui.fragments.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.pd.App
import com.example.pd.databinding.FragmentAuthorizationBinding
import com.example.pd.ui.main.SessionManager

class AuthorizationFragment : Fragment() {
    
    private lateinit var binding: FragmentAuthorizationBinding
    private lateinit var viewModel: AuthorizationViewModel
    private lateinit var sessionManager: SessionManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
        val token = sessionManager.getAuthToken()
        if (token != null && token != "") navigateToHomeFragment()
        initViewModel()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
    
        binding.registrationLabel.setOnClickListener {
            navigateToRegistrationFragment()
        }
    
        binding.authorizationButton.setOnClickListener {
            val login = binding.editLogin.text.toString()
            val password = binding.editPassword.text.toString()
            if (login.isEmpty() || password.isEmpty()) makeToast("Не все поля заполнены")
            else viewModel.login(login, password)
        }
    
        viewModel.token.observe(viewLifecycleOwner) {
            when (it) {
                "Not Found", "404", null, "" -> makeToast("Нет соединения с сервером")
                "Bad Request" -> makeToast("Неверный логин или пароль")
                else -> {
                    sessionManager.saveAuthToken(it)
                    sessionManager.getAuthToken()?.let {
                        navigateToHomeFragment()
                    }
                }
            }
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.loginFailedFlow.collect { loginFailed ->
                if (loginFailed) makeToast("Ошибка соединения с сервером")
            }
        }
    
        return binding.root
    }
    
    private fun initViewModel() {
        val authorizationRepository =
            (requireActivity().application as App).dependencyInjection.authorizationRepository
        val viewModelFactory =
            AuthorizationViewModelFactory(authorizationRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[AuthorizationViewModel::class.java]
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
    private fun navigateToHomeFragment() {
        val action =
            AuthorizationFragmentDirections.actionAuthorizationFragmentToHomeFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationFragment() {
        val action =
            AuthorizationFragmentDirections.actionAuthorizationFragmentToRegistrationFragment()
        findNavController().navigate(action)
    }
    
}