package com.example.pd.ui.fragments.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemRecommendBinding
import com.example.pd.ui.fragments.recommend.RecommendFragmentDirections
import com.example.pd.ui.model.SearchUiModel

/*class SearchAdapter {
}*/

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchHolder>() {

    private var searchList: List<SearchUiModel> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchHolder {
        val binding =
            ItemRecommendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        val search = searchList[position]
        holder.bind(search)
    }

    override fun getItemCount(): Int = searchList.size

    inner class SearchHolder(private val binding: ItemRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(searchUiModel: SearchUiModel) = binding.run {
            val labelReviews = "Отзывов: "
            binding.posterName.text = searchUiModel.name
            binding.posterAuthor.text = searchUiModel.author
            binding.posterGenres.text = searchUiModel.genres
            binding.posterRating.text = searchUiModel.rating.toString()
            binding.posterReviews.text = labelReviews + searchUiModel.reviews.toString()
            binding.posterDescription.text = searchUiModel.description

            poster.setOnClickListener {
                val action = RecommendFragmentDirections.actionRecommendFragmentToDetailsFragment()
                poster.findNavController().navigate(action)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(search: List<SearchUiModel>) {
        searchList = search
        notifyDataSetChanged()
    }
}