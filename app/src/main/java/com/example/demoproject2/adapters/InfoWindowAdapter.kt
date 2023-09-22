package com.example.demoproject2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.demoproject2.R
import com.example.demoproject2.activities.MainActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class InfoWindowAdapter(val mContext: Context?) : GoogleMap.InfoWindowAdapter {

    var infoWindow: View = LayoutInflater.from(mContext).inflate(R.layout.custom_info_window, null)

    override fun getInfoContents(p0: Marker): View {

        setInfo(p0)
        return  infoWindow
    }

    override fun getInfoWindow(p0: Marker): View? {
        setInfo(p0)
        return null
    }

    private fun setInfo(marker : Marker){

        // Find views in the custom info window layout
        val infoWindowImage = infoWindow.findViewById<ImageView>(R.id.cI_imageView)
        val infoWindowTitle = infoWindow.findViewById<TextView>(R.id.cI_textView_Name)
        val infoWindowRating = infoWindow.findViewById<TextView>(R.id.cI_textView_Ratting)
        val infoWindowReviews = infoWindow.findViewById<TextView>(R.id.cI_textView_Reviews)
        val infoWindowLocation = infoWindow.findViewById<TextView>(R.id.cI_textView_Location)
        val infoWindowOpens = infoWindow.findViewById<TextView>(R.id.cI_textView_Opens)
        val infoWindowLocIcon = infoWindow.findViewById<ImageView>(R.id.cI_imageView_locIcon)
        val infoWindowDistance = infoWindow.findViewById<TextView>(R.id.cI_textView_Distance)

        // Populate the custom info window views with data from the marker
        infoWindowImage.setImageResource(R.drawable.i)
        infoWindowTitle.text = marker.title
        infoWindowRating.text = "Rating 9.2"
        infoWindowReviews.text = "112 Reviews"
        infoWindowLocation.text = "Chungi Amar Sidhu"
        infoWindowOpens.text = "Open Now"
        infoWindowDistance.text = "0.2 mi"
    }
}