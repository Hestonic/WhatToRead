package com.example.pd.ui.fragments.profile

import android.app.AlertDialog
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
import com.example.pd.databinding.FragmentProfileBinding
import com.example.pd.ui.main.SessionManager

class ProfileFragment : Fragment() {
    
    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var sessionManager: SessionManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        sessionManager = SessionManager(requireContext())
        sessionManager.getAuthToken()?.let { viewModel.getUser(it) }
    
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.favouritesBlock.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToFavouritesFragment())
        }

        binding.readBlock.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToReadFragment())
        }

        binding.settingsBlock.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToSettingsFragment())
        }

        binding.exitButton.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Выход")
                .setMessage("Вы уверены, что хотите выйти из аккаунта?")
                .setPositiveButton("Да") { _, _ ->
                    sessionManager.deleteAuthToken()
                    navigateToAuthorizationFragment()
                }
                .setNegativeButton("Нет") { _, _ ->
                    Toast.makeText(requireContext(), "Выход отменён", Toast.LENGTH_LONG)
                }
                .create().show()
        }
    
        viewModel.profileModel.observe(viewLifecycleOwner) { profileUiModel ->
            binding.profileName.text = profileUiModel.name
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.getUserFailedFlow.collect { makeToast(it) }
        }
    
        return binding.root
    }
    
    private fun navigateToAuthorizationFragment() {
        val action =
            ProfileFragmentDirections.actionProfileFragmentToAuthorizationFragment()
        findNavController().navigate(action)
    }
    
    private fun initViewModel() {
        val userRepository =
            (requireActivity().application as App).dependencyInjection.userRepository
        val viewModelFactory =
            ProfileViewModelFactory(userRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[ProfileViewModel::class.java]
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
}