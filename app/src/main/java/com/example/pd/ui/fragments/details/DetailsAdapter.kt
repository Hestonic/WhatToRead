package com.example.pd.ui.fragments.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemExpandableDetailsBinding
import com.example.pd.ui.main.EqualSpacingItemDecoration
import com.example.pd.ui.model.DetailsObjectHolder
import com.example.pd.ui.model.ExpandableDescription

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.DetailsHolder>() {

    private var detailsList: List<ExpandableDescription> = emptyList()
    private val adapter = CommentsAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsHolder {
        val binding = ItemExpandableDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailsHolder, position: Int) {
        val details = detailsList[position]
        holder.bind(details)
    }

    override fun getItemCount(): Int = detailsList.size

    inner class DetailsHolder(private val binding: ItemExpandableDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            val context = itemView.context
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerview.addItemDecoration(
                EqualSpacingItemDecoration(8, EqualSpacingItemDecoration.HORIZONTAL)
            )
            adapter.setData(DetailsObjectHolder.billySummers.expandableDescription[2].comments)
        }

        fun bind(details: ExpandableDescription) = binding.run {
            tittle.text = details.tittle
            description.text = details.description
            expandableLayout.isVisible = details.visible
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ExpandableDescription>) {
        detailsList = data
        notifyDataSetChanged()
    }
}

