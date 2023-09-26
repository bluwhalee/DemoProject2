package com.example.demoproject2.bindingAdapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("number","perc")
fun addSpace(view: TextView, number: Float, perc: Int) {
    view.text = "${number.toInt()} / $perc%"
}
@BindingAdapter("rating")
fun addRating(view: TextView, rating: String) {
    view.text = "Rating $rating"
}

@BindingAdapter("image")
fun setImage(view: ImageView, image: Int) {
    view.setImageResource(image)
}