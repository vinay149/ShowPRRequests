package com.example.showprrequests

import android.app.Application
import com.example.showprrequests.showPrRequest.di.AppComponent
import com.example.showprrequests.showPrRequest.di.DaggerAppComponent

class ShowPrApplication : Application() {

    companion object{
       lateinit var instance:ShowPrApplication
    }

    val appComponent:AppComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}