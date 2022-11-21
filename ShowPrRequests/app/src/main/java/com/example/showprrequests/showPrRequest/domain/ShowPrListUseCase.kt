package com.example.showprrequests.showPrRequest.domain

import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import retrofit2.Call
import javax.inject.Inject

class ShowPrListUseCase @Inject constructor(private val showPrListRepositoryImpl: ShowPrListRepository){
      suspend fun getPrList(pageNumber:Int): Call<List<ShowPrListResponse>>{
           return showPrListRepositoryImpl.getPrListFromGithub(pageNumber)
      }
}