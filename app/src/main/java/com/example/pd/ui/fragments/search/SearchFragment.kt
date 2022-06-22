package com.example.pd.ui.fragments.search

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.App
import com.example.pd.R
import com.example.pd.databinding.FragmentSearchBinding
import com.example.pd.ui.main.FilterInstance
import com.example.pd.ui.model.SearchUiModel

class SearchFragment : Fragment() {
    
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchViewModel
    private lateinit var tempUiModelList: MutableList<SearchUiModel>
    private val adapter = SearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        initViewModel()
        viewModel.getBooks()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        setupRecycler()
    
        viewModel.searchUiModelLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.getBooksFailedFlow.collect { makeToast(it) }
        }
    
        return binding.root
    }
    
    override fun onResume() {
        super.onResume()
        if (FilterInstance.authors.isNotEmpty() || FilterInstance.genres.isNotEmpty())
            viewModel.getFilteredBooks()
        else viewModel.getBooks()
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
        val viewModelFactory = SearchViewModelFactory(booksRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_fragment, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_filter) {
            val action = SearchFragmentDirections.actionSearchFragmentToFilterFragment()
            findNavController().navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }
}