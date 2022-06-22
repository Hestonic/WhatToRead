package com.example.pd.ui.fragments.read

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemFavouritesBinding
import com.example.pd.ui.model.ReadUiModel

class ReadAdapter : RecyclerView.Adapter<ReadAdapter.ReadHolder>() {

    private var readList: List<ReadUiModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadHolder {
        val binding =
            ItemFavouritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReadHolder(binding)
    }

    override fun onBindViewHolder(holder: ReadHolder, position: Int) {
        val home = readList[position]
        holder.bind(home)
    }

    override fun getItemCount(): Int = readList.size

    inner class ReadHolder(private val binding: ItemFavouritesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(readUiModel: ReadUiModel) = binding.run {
            posterName.text = readUiModel.tittle
            posterAuthor.text = readUiModel.author
            posterReviews.text = "Отзывов ${readUiModel.reviews}"
            posterRating.text = readUiModel.rating.toString()

            favouriteLayout.setOnClickListener {
                favouriteLayout.findNavController()
                    .navigate(ReadFragmentDirections.actionReadFragmentToDetailsFragment("1"))
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(read: List<ReadUiModel>) {
        readList = read
        notifyDataSetChanged()
    }
}