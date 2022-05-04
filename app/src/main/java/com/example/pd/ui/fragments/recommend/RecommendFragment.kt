package com.example.pd.ui.fragments.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pd.databinding.FragmentRecommendBinding
import com.example.pd.ui.model.RecommendHolderData
import com.example.pd.ui.model.RecommendUiModel

class RecommendFragment : Fragment() {

    private lateinit var binding: FragmentRecommendBinding
    private val adapter = RecommendAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendBinding.inflate(inflater, container, false)
        setupRecycler()


        adapter.setData(RecommendHolderData.recommendList)

        return binding.root
    }

    private fun setupRecycler() {
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initViewModel() {
        // TODO:
    }
}