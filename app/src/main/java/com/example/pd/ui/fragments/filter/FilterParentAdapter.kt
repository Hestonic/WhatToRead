package com.example.pd.ui.fragments.filter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemFilterParentBinding
import com.example.pd.ui.main.EqualSpacingItemDecoration
import com.example.pd.ui.model.FilterItem
import com.example.pd.ui.model.FilterUiModel

class FilterParentAdapter : RecyclerView.Adapter<FilterParentAdapter.FilterHolder>() {
    
    private var filterUiModelList: List<FilterUiModel> = listOf()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        val binding =
            ItemFilterParentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterHolder(binding)
    }
    
    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
        filterUiModelList.getOrNull(position)?.let {
            holder.bind(it)
        }
    }
    
    override fun getItemCount(): Int = filterUiModelList.size
    
    inner class FilterHolder(private val binding: ItemFilterParentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val adapter = FilterChildAdapter()
        
        init {
            val context = itemView.context
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerview.addItemDecoration(
                EqualSpacingItemDecoration(8, EqualSpacingItemDecoration.HORIZONTAL)
            )
        }
        
        fun bind(filterUiModel: FilterUiModel) = binding.run {
            adapter.setData(filterUiModel.filterItems)
            binding.tittle.text = filterUiModel.title
            binding.expandableGroup.isVisible = filterUiModel.isVisible
            
            
            binding.searchView.addTextChangedListener {
                try {
                    val filteredList: MutableList<FilterItem> = mutableListOf()
                    val query = binding.searchView.text.toString()
                    filterUiModel.filterItems.forEach { filterItem ->
                        if (filterItem.name.contains(query, ignoreCase = true))
                            filteredList.add(filterItem)
                    }
                    adapter.setData(filteredList)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                
                
            }
            
            itemView.setOnClickListener {
                filterUiModel.isVisible = !filterUiModel.isVisible
                binding.expandableGroup.isVisible = filterUiModel.isVisible
            }
        }
    }
    
    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<FilterUiModel>) {
        filterUiModelList = data
        notifyDataSetChanged()
    }
}


