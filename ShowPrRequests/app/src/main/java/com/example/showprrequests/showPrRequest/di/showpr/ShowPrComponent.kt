package com.example.showprrequests.showPrRequest.di.showpr

import com.example.showprrequests.showPrRequest.presentation.ShowPrListFragment
import dagger.Component
import dagger.Subcomponent

@Subcomponent
interface ShowPrComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ShowPrComponent
    }

    fun inject(showOrFragment: ShowPrListFragment)

}