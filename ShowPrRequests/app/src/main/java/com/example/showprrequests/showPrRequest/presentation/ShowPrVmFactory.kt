package com.example.showprrequests.showPrRequest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.showprrequests.showPrRequest.domain.ShowPrListUseCase
import com.example.showprrequests.showPrRequest.presentation.adapter.ShowPrListViewModel
import javax.inject.Inject

class ShowPrVmFactory @Inject constructor(private val showPrListUseCase: ShowPrListUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ShowPrListViewModel::class.java) -> ShowPrListViewModel(showPrListUseCase) as T
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}