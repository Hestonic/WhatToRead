package com.example.pd.ui.fragments.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.App
import com.example.pd.databinding.FragmentRecommendBinding

class RecommendFragment : Fragment() {
    
    private lateinit var binding: FragmentRecommendBinding
    private lateinit var viewModel: RecommendViewModel
    private val adapter = RecommendAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        viewModel.getBooks()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendBinding.inflate(inflater, container, false)
        setupRecycler()
    
        viewModel.recommendUiModel.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.getBooksFailedFlow.collect { makeToast(it) }
        }
    
    
        return binding.root
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }

    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initViewModel() {
        val booksRepository =
            (requireActivity().application as App).dependencyInjection.booksRepository
        val viewModelFactory = RecommendViewModelFactory(booksRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[RecommendViewModel::class.java]
    }
}