package com.example.pd.ui.fragments.favourites

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemFavouritesBinding
import com.example.pd.ui.model.FavouritesUiModel

class FavouritesAdapter : RecyclerView.Adapter<FavouritesAdapter.FavouritesHolder>() {

    private var favouritesList: List<FavouritesUiModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesHolder {
        val binding =
            ItemFavouritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouritesHolder(binding)
    }

    override fun onBindViewHolder(holder: FavouritesHolder, position: Int) {
        val home = favouritesList[position]
        holder.bind(home)
    }

    override fun getItemCount(): Int = favouritesList.size

    inner class FavouritesHolder(private val binding: ItemFavouritesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(favouritesUiModel: FavouritesUiModel) = binding.run {
            posterName.text = favouritesUiModel.tittle
            posterAuthor.text = favouritesUiModel.author
            posterReviews.text = "Отзывов ${favouritesUiModel.reviews}"
            posterRating.text = favouritesUiModel.rating.toString()

            favouriteLayout.setOnClickListener {
                favouriteLayout.findNavController()
                    .navigate(FavouritesFragmentDirections.actionFavouritesFragmentToDetailsFragment())
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(favourites: List<FavouritesUiModel>) {
        favouritesList = favourites
        notifyDataSetChanged()
    }
}