package com.example.demoproject2.viewholders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.databinding.ItemCategoryBinding
import com.example.demoproject2.databinding.ItemFoodBinding
import com.example.demoproject2.dataclasses.Category
import com.example.demoproject2.dataclasses.Food

class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(food: Food){
        binding.apply {
            this.food = food
            executePendingBindings()
        }
    }
    companion object{
        fun fromParent(parent: ViewGroup,):FoodViewHolder{
            return FoodViewHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
    }
}