package com.example.showprrequests.showPrRequest.common

import android.content.Context
import android.net.ConnectivityManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.showprrequests.ShowPrApplication

class AppUtil {

    companion object {

        fun loadImage(imageView: ImageView, url: String) {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
            Glide.with(imageView.context).load(url).apply(options).into(imageView)
        }

        fun isNetworkAvailable(): Boolean {
            val activeNetworkInfo = ShowPrApplication.instance.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return activeNetworkInfo.activeNetworkInfo != null && activeNetworkInfo.activeNetworkInfo?.isConnected ?:false
        }
    }
}