package com.example.mymoviemvvm.mymvvmmovie.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mymvvmmovie.util.Constains

object ImageBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        if (url.isNotEmpty()) {
            Glide.with(imageView.context)
                .load(Constains.IMAGEBASEURL + Constains.IMAGE_W342 + url)
                .into(imageView)
        }

    }
}