package com.example.demoproject2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.R
import com.example.demoproject2.adapters.ReviewsGridAdapter
import com.example.demoproject2.databinding.FragmentReviewsBinding

class ReviewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentReviewsBinding
    private var imageList : ArrayList<Int> = ArrayList()
    private lateinit var reviewsGridAdapter: ReviewsGridAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewsBinding.inflate(layoutInflater)
        init()
        return binding.root
    }
    fun init(){
        recyclerView = binding.reviewsRecyclerView
        addIamges()
        reviewsGridAdapter = ReviewsGridAdapter(imageList)
        recyclerView.apply {
            layoutManager = GridLayoutManager(activity, 3)
            adapter = reviewsGridAdapter
        }
    }
    fun addIamges()
    {
        imageList.apply {
            add(R.drawable.a)
            add(R.drawable.b)
            add(R.drawable.c)
            add(R.drawable.d)
            add(R.drawable.g)
            add(R.drawable.f)
            add(R.drawable.i)
            add(R.drawable.h)
            add(R.drawable.j)
        }
    }
}