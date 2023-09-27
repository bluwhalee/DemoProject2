package com.example.demoproject2.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.dataclasses.Food
import com.example.demoproject2.viewholders.FoodViewHolder


class FoodAdapter(private val foods: List<Food>) : RecyclerView.Adapter<FoodViewHolder>() {

    //lifecycle
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder.fromParent(parent)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foods[position])

    }

    override fun getItemCount() = foods.size
}