package com.example.pd.ui.fragments.settings

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.pd.App
import com.example.pd.R
import com.example.pd.databinding.FragmentSettingsBinding
import com.example.pd.ui.fragments.settings.dialog.EditEmailDialogFragment
import com.example.pd.ui.fragments.settings.dialog.EditNameDialogFragment
import com.example.pd.ui.main.SessionManager

class SettingsFragment : Fragment() {
    
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var viewModel: SettingsViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
        initViewModel()
        sessionManager.getAuthToken()?.let { token -> viewModel.getUser(token) }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        
        binding.editName.setOnClickListener {
            try {
                val profileName = binding.profileName.text.toString().split(" ")
                val firstName = profileName.getOrNull(0)
                val lastName = profileName.getOrNull(1)
                val dialogEditName = EditNameDialogFragment(firstName, lastName)
                dialogEditName.show(childFragmentManager, "dialogEditName")
            } catch (e: Exception) {
                e.printStackTrace()
                makeToast("Дождитесь загрузки данных с сервера")
            }
        }
    
        binding.editPhone.setOnClickListener {
            try {
                val email = binding.phone.text.toString()
                Log.d("tag1", email)
                val dialogEditEmail = EditEmailDialogFragment(email)
                dialogEditEmail.show(childFragmentManager, "dialogEditEmail")
            } catch (e: Exception) {
                e.printStackTrace()
                makeToast("Дождитесь загрузки данных с сервера")
            }
        }
    
        viewModel.settingsUiModelLiveData.observe(viewLifecycleOwner) {
            binding.profileName.text = it.firstName + " " + it.lastName
            binding.phone.text = it.email
        }
    
        binding.avatar.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(requireContext()).inflate(R.layout.dialog_edit_avatar, null)
            val mBuilder = AlertDialog.Builder(requireContext())
                .setView(mDialogView)
            val mAlertDialog = mBuilder.show()
        
            val changeAvatar = mDialogView.findViewById<TextView>(R.id.change_avatar)
            val changeMiniature = mDialogView.findViewById<TextView>(R.id.change_miniature)
            changeAvatar.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Изменить фотографию",
                    Toast.LENGTH_SHORT
                )
                    .show()
                mAlertDialog.dismiss()
            }
        
            changeMiniature.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Изменить миниатюру",
                    Toast.LENGTH_SHORT
                )
                    .show()
                mAlertDialog.dismiss()
            }
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.getUserFailedFlow.collect { makeToast(it) }
        }
    
        return binding.root
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
    private fun initViewModel() {
        val userRepository =
            (requireActivity().application as App).dependencyInjection.userRepository
        val viewModelFactory = SettingsViewModelFactory(userRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[SettingsViewModel::class.java]
    }
}