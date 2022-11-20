package com.example.showprrequests.showPrRequest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import com.example.showprrequests.showPrRequest.domain.ShowPrListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ShowPrListViewModel @Inject constructor (private val showPrListUseCase: ShowPrListUseCase):ViewModel() {


    var prListData:MutableLiveData<List<ShowPrListResponse>> = MutableLiveData()

    init {
        loadData()
    }

    private fun loadData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                    prListData.postValue(showPrListUseCase.getPrList())
            }
        }
    }
}