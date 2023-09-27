package com.example.demoproject2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.R
import com.example.demoproject2.viewholders.ReviewsGridViewHolder

class ReviewsGridAdapter(private val imageList : ArrayList<Int>) : RecyclerView.Adapter<ReviewsGridViewHolder>() {

    //implemented
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsGridViewHolder {
        return  ReviewsGridViewHolder.fromParent(parent)
    }
    override fun onBindViewHolder(holder: ReviewsGridViewHolder, position: Int) {
        holder.bind(imageList[position])
    }
    override fun getItemCount() = imageList.size
}