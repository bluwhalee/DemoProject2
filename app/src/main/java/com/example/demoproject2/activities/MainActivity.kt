package com.example.demoproject2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.demoproject2.R
import com.example.demoproject2.adapters.MainVPAdapter
import com.example.demoproject2.databinding.ActivityMainBinding
import com.example.demoproject2.databinding.ItemCustomInfoWindowBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    //properties
    private lateinit var binding : ActivityMainBinding
    private lateinit var pager2: ViewPager2
    private lateinit var pagerAdapter : MainVPAdapter


    //lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    //private
    private fun init()
    {
        setupViewPager()
        setupTabLayout()
    }

    private fun setupViewPager() {
        pager2 = binding.mainViewPager
        pagerAdapter = MainVPAdapter(supportFragmentManager, lifecycle)
        binding.mainViewPager.adapter = pagerAdapter
        pager2.isUserInputEnabled = false
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.mainTabLayout,pager2){tab,position ->
            when(position){
                1->tab.text = "Maps"
                2->tab.text = "Category"
                else->tab.text = "Reviews"
            }
        }.attach()
    }
}