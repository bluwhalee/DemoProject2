package com.example.demoproject2.viewholders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.R
import com.example.demoproject2.databinding.FragmentCategoryBinding
import com.example.demoproject2.databinding.ItemCategoryBinding
import com.example.demoproject2.dataclasses.Category

class CategoryViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(category: Category){
        binding.apply {
            this.category = category
            executePendingBindings()
        }
        val dotColorDrawable = binding.colorCircle.background
        DrawableCompat.setTint(dotColorDrawable, Color.parseColor(category.color))
    }
    companion object{
        fun fromParent(parent: ViewGroup,):CategoryViewHolder{
            return CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
    }
}