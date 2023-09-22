package com.example.demoproject2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.demoproject2.R
import com.example.demoproject2.adapters.MainVPAdapter
import com.example.demoproject2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var pager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var pagerAdapter : MainVPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init()
    {
        pager2 = binding.mainViewPager
        tabLayout = binding.mainTabLayout
        pagerAdapter = MainVPAdapter(supportFragmentManager, lifecycle)
        pager2.adapter = pagerAdapter
        pager2.isUserInputEnabled = false

        TabLayoutMediator(tabLayout,pager2){tab,position ->
            when(position){
                1->tab.text = "Maps"
                2->tab.text = "Category"
                else->tab.text = "Reviews"
            }
        }.attach()

    }
}