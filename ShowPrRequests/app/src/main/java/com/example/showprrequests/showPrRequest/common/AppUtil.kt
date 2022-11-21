package com.example.showprrequests.showPrRequest.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AppUtil {
    companion object {

        fun loadImage(imageView: ImageView, url: String) {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
            Glide.with(imageView.context).load(url).apply(options).into(imageView)
        }
    }
}