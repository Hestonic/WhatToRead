package com.example.pd.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pd.databinding.FragmentHomeBinding
import com.example.pd.ui.model.HomeHolderData

class HomeFragment : Fragment() {

    // private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentHomeBinding
    private val adapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupRecycler()
        adapter.setData(HomeHolderData.detailsList)

        return binding.root
    }

    private fun initViewModel() {
    }

    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerview.hasFixedSize()
        /*binding.recyclerview.addItemDecoration()*/
    }
}