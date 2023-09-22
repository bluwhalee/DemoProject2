package com.example.demoproject2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.demoproject2.R
import com.example.demoproject2.activities.MainActivity
import com.example.demoproject2.adapters.InfoWindowAdapter
import com.example.demoproject2.databinding.FragmentMapBinding
import com.example.demoproject2.dataclasses.Marker
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.ui.IconGenerator

class MapFragment : Fragment() {

    private lateinit var binding : FragmentMapBinding
    private lateinit var mMap: GoogleMap
    private var markerList : ArrayList<Marker> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMapBinding.inflate(layoutInflater)

        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheetLayout = view.findViewById<ConstraintLayout>(R.id.bottom_sheet)
//
        // Set up BottomSheetBehavior
        BottomSheetBehavior.from(bottomSheetLayout).apply {
            peekHeight = 100
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
//        val bottomSheetFragment = BottomSheetFragment.newInstance(100)
//        bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)


    }

    private fun init() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun setUpClusterManager(mMap: GoogleMap) {
        val clusterManager = ClusterManager<Marker>(activity,mMap)
        mMap?.setOnCameraIdleListener(clusterManager)
        mMap.setOnMarkerClickListener(clusterManager)
        getAllMarker()
        clusterManager.addItems(markerList)
        clusterManager.cluster()
        clusterManager.markerCollection.setInfoWindowAdapter(InfoWindowAdapter(activity))

    }

    private fun getAllMarker() {
        markerList.apply {
            val latLng = LatLng (22.572645,88.363892)
            val latLng1 = LatLng (22.841150, 88.126373)
            val latLng2 = LatLng (23.693029, 86.953110)
            val latLng3 = LatLng (25.225420, 88.781273)
            val latLng4 = LatLng (22.330883, 88.270040)
            val latLng5 = LatLng (22.698742, 88.688636)
            val marker1 = Marker("Food1", latLng)
            val marker2 = Marker("Food2", latLng1)
            val marker3 = Marker("Food3", latLng2)
            val marker4 = Marker("Food4", latLng3)
            val marker5 = Marker("Food5", latLng4)
            val marker6 = Marker("Food6", latLng5)

            add(marker1)
            add(marker2)
            add(marker3)
            add(marker4)
            add(marker5)
            add(marker6)
        }
    }

    private val callback = OnMapReadyCallback { googleMap ->
        setUpClusterManager(googleMap)
    }
}