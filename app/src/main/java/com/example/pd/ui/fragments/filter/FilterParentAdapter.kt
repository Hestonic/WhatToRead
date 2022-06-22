package com.example.pd.ui.fragments.filter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemFilterParentBinding
import com.example.pd.ui.main.EqualSpacingItemDecoration
import com.example.pd.ui.model.FilterBox
import com.example.pd.ui.model.FilterObjectHolder

class FilterParentAdapter : RecyclerView.Adapter<FilterParentAdapter.FilterHolder>() {

    private var filterBoxes: List<FilterBox> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        val binding =
            ItemFilterParentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
        val home = filterBoxes[position]
        holder.bind(home)
    }

    override fun getItemCount(): Int = filterBoxes.size

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
            adapter.setData(FilterObjectHolder.filterBoxes[1].filter)
        }

        fun bind(filterBox: FilterBox) = binding.run {
            binding.tittle.text = filterBox.tittle
            binding.expandableGroup.isVisible = filterBox.isVisible


        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<FilterBox>) {
        filterBoxes = data
        notifyDataSetChanged()
    }
}


