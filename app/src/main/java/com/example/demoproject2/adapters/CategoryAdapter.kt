package com.example.demoproject2.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject2.dataclasses.Category
import com.example.demoproject2.viewholders.CategoryViewHolder

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    //lifecycle
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.fromParent(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])

    }

    override fun getItemCount() = categories.size
}