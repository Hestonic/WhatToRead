package com.example.pd.ui.fragments.comment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pd.App
import com.example.pd.R
import com.example.pd.databinding.FragmentCommentBinding

class CommentFragment : Fragment() {
    
    private lateinit var binding: FragmentCommentBinding
    private lateinit var viewModel: CommentViewModel
    private val args by navArgs<CommentFragmentArgs>()
    private var rating: Int = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        setHasOptionsMenu(true)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentBinding.inflate(inflater, container, false)
        
        binding.star1.setOnClickListener {
            rating = 1
            binding.star1.setImageResource(R.drawable.star_filled)
            binding.star2.setImageResource(R.drawable.star_black)
            binding.star3.setImageResource(R.drawable.star_black)
            binding.star4.setImageResource(R.drawable.star_black)
            binding.star5.setImageResource(R.drawable.star_black)
        }
        
        binding.star2.setOnClickListener {
            rating = 2
            binding.star1.setImageResource(R.drawable.star_filled)
            binding.star2.setImageResource(R.drawable.star_filled)
            binding.star3.setImageResource(R.drawable.star_black)
            binding.star4.setImageResource(R.drawable.star_black)
            binding.star5.setImageResource(R.drawable.star_black)
        }
        
        binding.star3.setOnClickListener {
            rating = 3
            binding.star1.setImageResource(R.drawable.star_filled)
            binding.star2.setImageResource(R.drawable.star_filled)
            binding.star3.setImageResource(R.drawable.star_filled)
            binding.star4.setImageResource(R.drawable.star_black)
            binding.star5.setImageResource(R.drawable.star_black)
        }
        
        binding.star4.setOnClickListener {
            rating = 4
            binding.star1.setImageResource(R.drawable.star_filled)
            binding.star2.setImageResource(R.drawable.star_filled)
            binding.star3.setImageResource(R.drawable.star_filled)
            binding.star4.setImageResource(R.drawable.star_filled)
            binding.star5.setImageResource(R.drawable.star_black)
        }
        
        binding.star5.setOnClickListener {
            rating = 5
            binding.star1.setImageResource(R.drawable.star_filled)
            binding.star2.setImageResource(R.drawable.star_filled)
            binding.star3.setImageResource(R.drawable.star_filled)
            binding.star4.setImageResource(R.drawable.star_filled)
            binding.star5.setImageResource(R.drawable.star_filled)
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.commentFailedFlow.collect { makeToast(it) }
        }
        
        return binding.root
    }
    
    private fun initViewModel() {
        val commentRepository =
            (requireActivity().application as App).dependencyInjection.commentRepository
        val viewModelFactory = CommentViewModelFactory(commentRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[CommentViewModel::class.java]
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_comment, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_check) {
            val comment = binding.commentText.text.toString()
            if (comment.isNotEmpty())
                when (rating) {
                    0 -> makeToast("Пожалуйста, оцените книгу")
                    else -> publishComment(comment)
                }
            else makeToast("Поделитесь своим мнением о книге")
        }
        return super.onOptionsItemSelected(item)
    }
    
    private fun publishComment(comment: String) {
        viewModel.publishComment(args.bookId, rating, comment)
        
        val action =
            CommentFragmentDirections.actionCommentFragmentToDetailsFragment(args.bookId)
        findNavController().navigate(action)
        makeToast("Ваш комментарий добавлен")
    }
    
    
}