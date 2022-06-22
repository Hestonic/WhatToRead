package com.example.pd.ui.fragments.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.R
import com.example.pd.databinding.FragmentReadBinding
import com.example.pd.ui.model.ReadDataHolder

class ReadFragment : Fragment() {

    private lateinit var binding: FragmentReadBinding
    private val adapter = ReadAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReadBinding.inflate(inflater, container, false)
        setupRecycler()
        adapter.setData(ReadDataHolder.readList)
        return binding.root
    }

    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initViewModel() {

    }

}