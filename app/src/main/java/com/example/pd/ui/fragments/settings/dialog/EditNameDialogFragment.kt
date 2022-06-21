package com.example.pd.ui.fragments.settings.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.pd.databinding.DialogEditNameBinding

class EditNameDialogFragment(private val firstName: String?, private val lastName: String?) :
    DialogFragment() {
    
    private lateinit var binding: DialogEditNameBinding
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogEditNameBinding.inflate(inflater, container, false)
        firstName?.let { binding.name.setText(it) }
        lastName?.let { binding.surname.setText(it) }
        return binding.root
    }
}