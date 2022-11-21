package com.example.showprrequests.showPrRequest.presentation.adapter

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
    var dataFetchingState:MutableLiveData<ShowPrListState> = MutableLiveData(ShowPrListState.LOADING)

    fun loadData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = showPrListUseCase.getPrList()
                data.enqueue(object : Callback<List<ShowPrListResponse>> {

                    override fun onResponse(
                        call: Call<List<ShowPrListResponse>>,
                        response: Response<List<ShowPrListResponse>>
                    ) {
                        response.body()?.let {
                            prListData.postValue(it)
                        }
                        dataFetchingState.postValue(ShowPrListState.FETCHED)
                    }

                    override fun onFailure(call: Call<List<ShowPrListResponse>>, t: Throwable) {
                        dataFetchingState.postValue(ShowPrListState.FAILED)
                        prListData.postValue(emptyList())
                    }

                })
            }
        }
    }
}

enum class ShowPrListState{
    LOADING,
    FETCHED,
    FAILED
}