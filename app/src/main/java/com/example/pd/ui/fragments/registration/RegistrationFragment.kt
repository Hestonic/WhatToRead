package com.example.pd.ui.fragments.registration

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
import com.example.pd.databinding.FragmentRegistrationBinding
import com.example.pd.ui.main.SessionManager
import java.util.regex.Matcher
import java.util.regex.Pattern

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
            navigateToAuthorizationFragment()
        }
    
        binding.registrationButton.setOnClickListener {
            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val passwordRepeat = binding.editPasswordRepeat.text.toString()
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordRepeat.isEmpty())
                makeToast("Не все поля заполнены")
            else if (password != passwordRepeat)
                makeToast("Пароли не совпадают")
            else if (!isPasswordsLengthValid(password, passwordRepeat))
                makeToast("Минимальная длинна пароля 6 символов")
            else if (!isEmailValid(email))
                makeToast("Неверный формат электронной почты")
            else viewModel.registration(name, email, password, passwordRepeat)
            
        }
    
        viewModel.token.observe(viewLifecycleOwner) {
            when (it) {
                "Not Found", "404", null, "" -> makeToast("Нет соединения с сервером")
                "Bad Request" -> makeToast("Такой email уже существует")
                else -> {
                    sessionManager.saveAuthToken(it)
                    sessionManager.getAuthToken()?.let {
                        navigateToHomeFragment()
                    }
                }
            }
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.registrationFailedFlow.collect { registrationFailed ->
                if (registrationFailed) makeToast("Ошибка соединения с сервером")
            }
        }
    
        return binding.root
    }
    
    private fun initViewModel() {
        val authorizationRepository =
            (requireActivity().application as App).dependencyInjection.authorizationRepository
        val viewModelFactory =
            RegistrationViewModelFactory(authorizationRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[RegistrationViewModel::class.java]
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
    private fun isEmailValid(email: String): Boolean {
        val regExpression = ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
          + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
          + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
          + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
          + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
          + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")
        val inputStr: CharSequence = email
        val pattern: Pattern = Pattern.compile(regExpression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(inputStr)
        return matcher.matches()
    }
    
    private fun isPasswordsLengthValid(password: String, passwordRepeat: String): Boolean {
        return password.length > 5 && passwordRepeat.length > 5
    }
    
    private fun navigateToAuthorizationFragment() {
        val action =
            RegistrationFragmentDirections.actionRegistrationFragmentToAuthorizationFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToHomeFragment() {
        val action =
            RegistrationFragmentDirections.actionRegistrationFragmentToHomeFragment()
        findNavController().navigate(action)
    }
    
}