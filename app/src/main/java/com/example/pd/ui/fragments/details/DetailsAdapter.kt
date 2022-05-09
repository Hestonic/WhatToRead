package com.example.pd.ui.fragments.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemExpandableDetailsBinding
import com.example.pd.ui.model.ExpandableDescription

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.DetailsHolder>() {

    private var detailsList: List<ExpandableDescription> = emptyList()

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
        fun bind(details: ExpandableDescription) = binding.run {
            binding.tittle.text = details.tittle
            binding.description.text = details.description

            val isVisible = details.visible
            binding.expandableLayout.isVisible = isVisible
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(detailsL: List<ExpandableDescription>) {
        detailsList = detailsL
        notifyDataSetChanged()
    }
}

