package com.example.pd.ui.fragments.settings

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pd.R
import com.example.pd.databinding.DialogEditNameBinding
import com.example.pd.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.editName.setOnClickListener {
            val dialogEditNameBinding = DialogEditNameBinding.inflate(inflater, container, false)
            val mBuilder = AlertDialog.Builder(requireContext())
                .setView(dialogEditNameBinding.root)
            val mAlertDialog = mBuilder.show()

            /*TODO: dialog fragment*/
            dialogEditNameBinding.saveChanges.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }

        binding.editPhone.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(requireContext()).inflate(R.layout.dialog_edit_phone, null)
            val mBuilder = AlertDialog.Builder(requireContext())
                .setView(mDialogView)
            val mAlertDialog = mBuilder.show()

            val savePhoneButton = mDialogView.findViewById<TextView>(R.id.save_phone)
            val editPhone = mDialogView.findViewById<EditText>(R.id.phone)
            savePhoneButton.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Данные успешно изменены, ${editPhone.text}",
                    Toast.LENGTH_SHORT
                )
                    .show()
                mAlertDialog.dismiss()
            }
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

        return binding.root
    }
}