package com.example.pd.ui.fragments.filter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.R
import com.example.pd.databinding.ItemFilterChildBinding
import com.example.pd.ui.main.FilterInstance
import com.example.pd.ui.model.FilterItem

class FilterChildAdapter : RecyclerView.Adapter<FilterChildAdapter.FilterChildHolder>() {
    
    private var filterItems: List<FilterItem> = listOf()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterChildHolder {
        val binding =
            ItemFilterChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterChildHolder(binding)
    }
    
    override fun onBindViewHolder(holder: FilterChildHolder, position: Int) {
        filterItems.getOrNull(position)?.let {
            holder.bind(it)
        }
    }
    
    override fun getItemCount(): Int = filterItems.size
    
    inner class FilterChildHolder(private val binding: ItemFilterChildBinding) :
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(filterItem: FilterItem) = binding.run {
            binding.name.text = filterItem.name
            val filterInstanceContainsCurrentGenre =
                FilterInstance.genres.contains(filterItem.name)
            val filterInstanceContainsCurrentAuthor =
                FilterInstance.authors.contains(filterItem.name)
            
            if (filterInstanceContainsCurrentGenre || filterInstanceContainsCurrentAuthor)
                binding.checkbox.setImageResource(R.drawable.check_ring_filled)
            else binding.checkbox.setImageResource(R.drawable.check_ring_black)
            
            itemView.setOnClickListener {
                if (filterItem.id == FilterInstance.GENRE_LABEL)
                    if (FilterInstance.genres.contains(filterItem.name))
                        FilterInstance.genres.remove(filterItem.name)
                    else FilterInstance.genres.add(filterItem.name)
                else if (filterItem.id == FilterInstance.AUTHOR_LABEL)
                    if (FilterInstance.authors.contains(filterItem.name))
                        FilterInstance.authors.remove(filterItem.name)
                    else FilterInstance.authors.add(filterItem.name)
                
                notifyDataSetChanged()
            }
            
        }
    }
    
    @SuppressLint("NotifyDataSetChanged")
    fun setData(filterItems: List<FilterItem>) {
        this.filterItems = filterItems
        notifyDataSetChanged()
    }
    
    fun getData(): List<FilterItem> = filterItems
}

