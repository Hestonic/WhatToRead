package com.example.pd.ui.fragments.filter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemFilterChildBinding
import com.example.pd.databinding.ItemFilterParentBinding
import com.example.pd.ui.model.FilterUiModel

class FilterChildAdapter : RecyclerView.Adapter<FilterChildAdapter.FilterChildHolder>() {

    private var filters: List<FilterUiModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterChildHolder {
        val binding =
            ItemFilterChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterChildHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterChildHolder, position: Int) {
        val home = filters[position]
        holder.bind(home)
    }

    override fun getItemCount(): Int = filters.size

    inner class FilterChildHolder(private val binding: ItemFilterChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(filters: FilterUiModel) = binding.run {
            binding.name.text = filters.name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<FilterUiModel>) {
        filters = data
        notifyDataSetChanged()
    }
}

