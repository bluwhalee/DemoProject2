package com.example.demoproject2.dataclasses

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class Marker(val name : String, val latlong: LatLng) : ClusterItem {
    override fun getPosition(): LatLng {
        return latlong
    }

    override fun getTitle(): String? {
        return name
    }

    override fun getSnippet(): String? {
        return ""
    }

    override fun getZIndex(): Float? {
        return null
    }
}