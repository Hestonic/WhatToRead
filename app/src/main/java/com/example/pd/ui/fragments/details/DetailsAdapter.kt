package com.example.pd.ui.fragments.details

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemExpandableDetailsBinding
import com.example.pd.ui.main.EqualSpacingItemDecoration
import com.example.pd.ui.model.ExpandableDescription

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.DetailsHolder>() {

    private var detailsList: List<ExpandableDescription> = emptyList()
    private val adapter = CommentsAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsHolder {
        val binding = ItemExpandableDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailsHolder, position: Int) {
        detailsList.getOrNull(position)?.let {
            holder.bind(it)
        }
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

//            adapter.setData(DetailsObjectHolder.billySummers.expandableDescription[2].comments)
        }

        fun bind(details: ExpandableDescription) = binding.run {
            adapter.setData(details.comments)
            Log.d("tag", "${details.tittle} ${details.visible}")
            tittle.text = details.tittle
            description.text = details.description
            expandableLayout.isVisible = details.visible
            binding.recyclerview.isVisible = details.commentsVisible
            binding.addComment.isVisible = details.commentsVisible
            binding.description.isVisible = !details.commentsVisible
    
            itemView.setOnClickListener {
                details.visible = !details.visible
                binding.expandableLayout.isVisible = details.visible
            }
    
            binding.addComment.setOnClickListener {
                val action = DetailsFragmentDirections.actionDetailsFragmentToCommentFragment()
                itemView.findNavController().navigate(action)
            }
    
            /*if (details.visible) {
               binding.icExpand.setImageResource(R.drawable.expand_up_bold)
               binding.tittle.setTypeface(null, Typeface.BOLD)
           } else {
               binding.icExpand.setImageResource(R.drawable.expand_down_light)
               binding.tittle.setTypeface(null, Typeface.NORMAL)
           }*/
    
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ExpandableDescription>) {
        detailsList = data
        notifyDataSetChanged()
    }
}

