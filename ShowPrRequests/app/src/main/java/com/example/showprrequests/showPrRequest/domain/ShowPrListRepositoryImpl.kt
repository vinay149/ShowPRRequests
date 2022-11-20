package com.example.showprrequests.showPrRequest.domain

import android.util.Log
import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ShowPrListRepositoryImpl @Inject constructor(private val showPrListService: ShowPrListService) : ShowPrListRepository {

    override suspend fun getPrListFromGithub():List<ShowPrListResponse>{
        val result:MutableList<ShowPrListResponse>  = ArrayList()
        showPrListService.getPrList().enqueue(object :
              Callback<List<ShowPrListResponse>> {

              override fun onResponse(
                  call: Call<List<ShowPrListResponse>>,
                  response: Response<List<ShowPrListResponse>>
              ) {
                  Log.d("Received All Data1111::",response.message()+"Here::"+Gson().toJson(response.body()))
                  response.body()?.let { result.addAll(it) }
              }

              override fun onFailure(call: Call<List<ShowPrListResponse>>, t: Throwable) {
                  Log.d("Received All Data1111::","Fail")
                   result.addAll(emptyList())
              }

          })
        return result
    }
}