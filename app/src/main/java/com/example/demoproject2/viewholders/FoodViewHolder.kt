package com.example.demoproject2.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.databinding.ItemFoodBinding
import com.example.demoproject2.dataclasses.Food

class FoodViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
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