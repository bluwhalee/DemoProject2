package com.example.demoproject2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.demoproject2.R
import com.example.demoproject2.databinding.ItemCustomInfoWindowBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class InfoWindowAdapter(val mContext: Context?) : GoogleMap.InfoWindowAdapter {

    private var binding = ItemCustomInfoWindowBinding.inflate(LayoutInflater.from(mContext), null , false)
    //implemented
    override fun getInfoContents(p0: Marker): View {

        setInfo(p0)
        return  binding.root
    }

    override fun getInfoWindow(p0: Marker): View? {
        setInfo(p0)
        return null
    }
    //private
    private fun setInfo(marker : Marker){

        binding.apply {
            binding.cIImageView.setImageResource(R.drawable.i)
            binding.cITextViewName.text = marker.title
            binding.cITextViewRatting.text = "Rating 9.2"
            binding.cITextViewReviews.text = "112 Reviews"
            binding.cITextViewLocation.text = "Chungi Amar Sidhu"
            binding.cITextViewOpens.text = "Open Now"
            binding.cITextViewDistance.text = "0.2 mi"
        }
    }
}