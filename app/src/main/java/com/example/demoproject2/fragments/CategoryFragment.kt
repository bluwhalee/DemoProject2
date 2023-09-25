package com.example.demoproject2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoproject2.R
import com.example.demoproject2.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    private lateinit var binding : FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init() {

    }
}