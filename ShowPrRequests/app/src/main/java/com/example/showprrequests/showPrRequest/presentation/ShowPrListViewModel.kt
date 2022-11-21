package com.example.showprrequests.showPrRequest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import com.example.showprrequests.showPrRequest.domain.ShowPrListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ShowPrListViewModel @Inject constructor (private val showPrListUseCase: ShowPrListUseCase):ViewModel() {
    var prListData:MutableLiveData<List<ShowPrListResponse>> = MutableLiveData()

    fun loadData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = showPrListUseCase.getPrList()
                data.enqueue(object :
                    Callback<List<ShowPrListResponse>> {

                    override fun onResponse(
                        call: Call<List<ShowPrListResponse>>,
                        response: Response<List<ShowPrListResponse>>
                    ) {
                        response.body()?.let { prListData.postValue(it) }
                    }

                    override fun onFailure(call: Call<List<ShowPrListResponse>>, t: Throwable) {
                        prListData.postValue(emptyList())
                    }

                })
            }
        }
    }
}