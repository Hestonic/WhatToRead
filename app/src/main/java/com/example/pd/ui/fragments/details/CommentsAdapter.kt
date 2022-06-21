package com.example.pd.ui.fragments.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemCommentBinding
import com.example.pd.ui.model.Comment

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.CommentsHolder>() {

    private var comments: List<Comment> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsHolder, position: Int) {
        comments.getOrNull(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = comments.size

    inner class CommentsHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Comment) = binding.run {
            binding.name.text = comment.name
            binding.comment.text = comment.comment
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Comment>) {
        comments = data
        notifyDataSetChanged()
    }
}
