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
        if (sessionManager.getAuthToken() != null) navigateToHomeFragment()
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
            else makeToast("Не все поля заполнены")
        }
    
        viewModel.authorizationToken.observe(viewLifecycleOwner) {
            if (it != "") {
                sessionManager.saveAuthToken(it)
                sessionManager.getAuthToken()?.let { token ->
                    viewModel.getUser(token)
                }
            } else  makeToast("Не удалось получить данные с сервера")
            
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.navigationFlow.collect { getUserIsSuccess ->
                if (getUserIsSuccess) navigateToHomeFragment()
                else makeToast("Войти не удалось")
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
        val userRepository =
            (requireActivity().application as App).dependencyInjection.userRepository
        val viewModelFactory =
            AuthorizationViewModelFactory(authorizationRepository, userRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[AuthorizationViewModel::class.java]
    }
    
    private fun navigateToHomeFragment() {
        val action =
            AuthorizationFragmentDirections.actionAuthorizationFragmentToHomeFragment()
        findNavController().navigate(action)
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
}