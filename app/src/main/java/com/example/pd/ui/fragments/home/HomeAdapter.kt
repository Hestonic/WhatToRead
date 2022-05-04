package com.example.pd.ui.fragments.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemHomeBinding
import com.example.pd.ui.model.HomeUiModel

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var homeList: List<HomeUiModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        val home = homeList[position]
        holder.bind(home)
    }

    override fun getItemCount(): Int = homeList.size

    inner class HomeHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(home: HomeUiModel) = binding.run {
            tittle.text = home.tittle

            rowLayout.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToRecommendFragment()
                rowLayout.findNavController().navigate(action)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(homeUiModelList: List<HomeUiModel>) {
        homeList = homeUiModelList
        notifyDataSetChanged()
    }
}