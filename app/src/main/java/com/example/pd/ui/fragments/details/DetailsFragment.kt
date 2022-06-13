package com.example.pd.ui.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.databinding.FragmentDetailsBinding
import com.example.pd.ui.model.DetailsObjectHolder

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val adapter = DetailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }
// TODO: recyclerview accordion
    // TODO: render adapter, recyclerview adapter delegate
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setupRecycler()
        adapter.setData(DetailsObjectHolder.billySummers.expandableDescription)
        return binding.root
    }

    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.hasFixedSize()
    }

    private fun initViewModel() {
        // TODO:
    }
}