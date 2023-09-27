package com.example.demoproject2.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.R

class ReviewsGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(imageId: Int){
        itemView.findViewById<ImageView>(R.id.food_imageView).setImageResource(imageId)
    }
    companion object {
        fun fromParent(parent : ViewGroup) : ReviewsGridViewHolder{
            return ReviewsGridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.grid_item,parent, false))
        }
    }
}