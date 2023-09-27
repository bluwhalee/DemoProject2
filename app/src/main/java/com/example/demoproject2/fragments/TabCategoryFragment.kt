package com.example.demoproject2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoproject2.R
import com.example.demoproject2.adapters.FoodAdapter
import com.example.demoproject2.databinding.FragmentTabCategoryBinding
import com.example.demoproject2.databinding.ItemFoodBinding
import com.example.demoproject2.dataclasses.Food


class TabCategoryFragment : Fragment() {

    private lateinit var binding: FragmentTabCategoryBinding

    //lifecycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabCategoryBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    //private
    private fun init(){
        setRecyclerViews()
    }

    private fun setRecyclerViews() {
        val foods = mutableListOf<Food>()
        foods.apply {
            add(Food("1. Mini Pancake", R.drawable.a, "9.2"))
            add(Food("2. Avacado Burger", R.drawable.b, "8.2"))
            add(Food("1. Pepi Pizza", R.drawable.c, "3.2"))
            add(Food("1. Idaho Pizza", R.drawable.d, "2"))
        }
        binding.horizontalRecyclerView.apply {
          adapter = FoodAdapter(foods)
          layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
        }
        binding.horizontalRecyclerView2.apply {
            adapter = FoodAdapter(foods)
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
        }
    }

}