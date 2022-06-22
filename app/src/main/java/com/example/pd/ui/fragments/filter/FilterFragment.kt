package com.example.pd.ui.fragments.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.App
import com.example.pd.databinding.FragmentFilterBinding

class FilterFragment : Fragment() {
    
    private lateinit var binding: FragmentFilterBinding
    private lateinit var viewModel: FilterViewModel
    private val adapter = FilterParentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        viewModel.getFilter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        setupRecycler()
        
        viewModel.filterLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        return binding.root
    }

    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initViewModel() {
        val filterRepository =
            (requireActivity().application as App).dependencyInjection.filterRepository
        val viewModelFactory = FilterViewModelFactory(filterRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[FilterViewModel::class.java]
    }
}