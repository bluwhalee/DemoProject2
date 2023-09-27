package com.example.demoproject2.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demoproject2.fragments.CategoryFragment
import com.example.demoproject2.fragments.MapFragment
import com.example.demoproject2.fragments.ReviewsFragment

class MainVPAdapter(fragmentManager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle)  {

    //implemented
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            1-> MapFragment()
            2 -> CategoryFragment()
            else -> ReviewsFragment()
        }
    }
}