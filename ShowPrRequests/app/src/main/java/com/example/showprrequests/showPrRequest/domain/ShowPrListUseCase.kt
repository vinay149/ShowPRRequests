package com.example.showprrequests.showPrRequest.domain

import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import javax.inject.Inject

class ShowPrListUseCase @Inject constructor(private val showPrListRepositoryImpl: ShowPrListRepository){
      suspend fun getPrList(): List<ShowPrListResponse>{
           return showPrListRepositoryImpl.getPrListFromGithub()
      }
}