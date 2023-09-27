package com.example.demoproject2.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoproject2.R
import com.example.demoproject2.adapters.CategoryAdapter
import com.example.demoproject2.databinding.FragmentCategoryBinding
import com.example.demoproject2.dataclasses.Category
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class CategoryFragment : Fragment() {

    private lateinit var binding : FragmentCategoryBinding
    private var categories : ArrayList<Category> = ArrayList()
    private lateinit var pieDataSet: PieDataSet
    private lateinit var tabLayout: TabLayout

    //lifecycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCategoryBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    //private
    private fun init() {
        setData()
        setPieChart()
        setRecyclerView()
        setTabLayout()

    }

    private fun setTabLayout() {
        tabLayout = binding.tabLayout
        categories.forEach{ category: Category ->
            var tabname = "${category.name}(${category.number.toInt()})"
            binding.tabLayout.addTab(tabLayout.newTab().setText(tabname))
         }
        childFragmentManager.beginTransaction()
            .replace(R.id.tab_fragment, TabCategoryFragment())
            .commit()

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.tab_fragment, TabCategoryFragment())
                        .commit()
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                return
            }
        })
    }

    private fun setRecyclerView() {
        binding.categoryRecyclerView.apply {
            adapter = CategoryAdapter(categories)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setData() {
           val dummyList =  mutableListOf<Category>(
                Category("Brunch", 460f, "#5499CB", 83),
                Category("Burgers", 61f, "#E27E46",11),
                Category("Pizza", 26f,"#C23E38",5),
                Category("Bangels", 3f,"#6EB895",1),
                Category("Tacos", 2f, "#597896",0),
                Category("Donuts", 1f,"#6DB9C7",0),
                Category("Coffee", 1f, "#F1B65A",0),
                Category("Bar", 1f,"#F1B65A",0)
           )
            categories.addAll(dummyList)
    }
    private fun setPieChart() {
        val list: ArrayList<PieEntry> = ArrayList()
        list.apply {
            categories.forEach{c -> add(PieEntry(c.number))}
        }
        pieDataSet = PieDataSet(list, "list")

        pieDataSet.colors.apply {
            categories.forEach{c-> add(Color.parseColor(c.color))}
        }

        binding.pieChart.apply {
            data = PieData(pieDataSet).apply {
                setValueTextSize(0f)
            }
            holeRadius = 75f
            description.isEnabled = false
            legend.isEnabled = false
            setDrawEntryLabels(false)
        }

    }

}