package com.example.pd.ui.fragments.settings.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.pd.databinding.DialogEditPhoneBinding

class EditEmailDialogFragment(private val email: String) : DialogFragment() {
    
    private lateinit var binding: DialogEditPhoneBinding
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogEditPhoneBinding.inflate(inflater, container, false)
        binding.phone.setText(email)
        return binding.root
    }
    
}