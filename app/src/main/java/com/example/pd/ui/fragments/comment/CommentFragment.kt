package com.example.pd.ui.fragments.comment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pd.databinding.FragmentCommentBinding

class CommentFragment : Fragment() {
    
    private lateinit var binding: FragmentCommentBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentBinding.inflate(inflater, container, false)
        
        
        
        return binding.root
    }
    
}