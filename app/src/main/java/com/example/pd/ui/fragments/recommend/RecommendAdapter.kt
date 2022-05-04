package com.example.pd.ui.fragments.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pd.databinding.ItemRecommendBinding
import com.example.pd.ui.model.RecommendUiModel

class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.RecommendHolder>() {

    private var recommendList: List<RecommendUiModel> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendHolder {
        val binding =
            ItemRecommendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendHolder, position: Int) {
        val recommend = recommendList[position]
        holder.bind(recommend)
    }

    override fun getItemCount(): Int = recommendList.size

    inner class RecommendHolder(private val binding: ItemRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recommendUiModel: RecommendUiModel) = binding.run {
            val labelReviews = "Отзывов: "
            binding.posterName.text = recommendUiModel.name
            binding.posterAuthor.text = recommendUiModel.author
            binding.posterGenres.text = recommendUiModel.genres
            binding.posterRating.text = recommendUiModel.rating.toString()
            binding.posterReviews.text = labelReviews + recommendUiModel.reviews.toString()
            binding.posterDescription.text = recommendUiModel.description

            poster.setOnClickListener {
                val action = RecommendFragmentDirections.actionRecommendFragmentToDetailsFragment()
                poster.findNavController().navigate(action)
            }
        }
    }

    fun setData(recommends: List<RecommendUiModel>) {
        recommendList = recommends
        notifyDataSetChanged()
    }
}