package com.example.showprrequests.showPrRequest.di

import com.example.showprrequests.showPrRequest.di.showpr.ShowPrComponent
import com.example.showprrequests.showPrRequest.di.showpr.ShowPrModule
import dagger.Component

@Component(modules = [AppModule::class,ShowPrModule::class])
interface AppComponent {
    fun showPrComponent():ShowPrComponent.Factory
}