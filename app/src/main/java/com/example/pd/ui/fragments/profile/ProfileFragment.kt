package com.example.pd.ui.fragments.profile

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pd.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

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
                .setTitle("Обновить данные")
                .setMessage("Данные устарели, поэтому перед обменом их необходимо обновить")
                .setPositiveButton("Да") { _, _ -> }
                .setNegativeButton("Нет") { _, _ -> }
                .create().show()
        }

        binding.exitButton.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToAuthorizationFragment())
        }

        return binding.root
    }
}