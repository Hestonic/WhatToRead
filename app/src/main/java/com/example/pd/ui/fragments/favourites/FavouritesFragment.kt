package com.example.pd.ui.fragments.favourites

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.databinding.FragmentFavouritesBinding
import com.example.pd.ui.model.FavouritesDataHolder

class FavouritesFragment : Fragment() {

    private lateinit var binding: FragmentFavouritesBinding
    private val adapter = FavouritesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        setupRecycler()
        Log.d("asdasd", FavouritesDataHolder.favouriteList.toString())
        adapter.setData(FavouritesDataHolder.favouriteList)
        return binding.root
    }

    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initViewModel() {

    }
}