package com.example.pd.ui.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.App
import com.example.pd.databinding.FragmentDetailsBinding
import com.example.pd.ui.model.DetailsUiModel

class DetailsFragment : Fragment() {
    
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    private val args by navArgs<DetailsFragmentArgs>()
    private val adapter = DetailsAdapter()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        viewModel.getBook(args.id)
    }
    
    // TODO: render adapter, recyclerview adapter delegate
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setupRecycler()
        viewModel.detailsUiModelLiveData.observe(viewLifecycleOwner) { detailsUiModel ->
            adapter.setData(detailsUiModel)
            setUi(detailsUiModel)
        }
        
        lifecycleScope.launchWhenStarted {
            viewModel.getBookFailedFlow.collect { makeToast(it) }
        }
        
        return binding.root
    }
    
    private fun setUi(detailsUiModel: DetailsUiModel) {
        binding.posterName.text = detailsUiModel.title
        binding.author.text = detailsUiModel.author
        binding.genres.text = detailsUiModel.genres
        binding.ratingValue.text = detailsUiModel.averageRating
        binding.posterReviews.text = detailsUiModel.reviews
        binding.ageLimit.text = detailsUiModel.ageLimit
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.hasFixedSize()
    }
    
    private fun initViewModel() {
        val booksRepository =
            (requireActivity().application as App).dependencyInjection.booksRepository
        val viewModelFactory = DetailsViewModelFactory(booksRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]
    }
}