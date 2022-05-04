package com.example.pd.ui.fragments.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
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
        val home = detailsList[position]
        holder.bind(home)
    }

    override fun getItemCount(): Int = detailsList.size

    inner class DetailsHolder(private val binding: ItemExpandableDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(home: ExpandableDescription) = binding.run {

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(details: List<ExpandableDescription>) {
        detailsList = details
        notifyDataSetChanged()
    }
}

