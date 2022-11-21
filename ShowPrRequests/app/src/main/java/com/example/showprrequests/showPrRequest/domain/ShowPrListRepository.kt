package com.example.showprrequests.showPrRequest.domain

import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface ShowPrListRepository {
    suspend fun getPrListFromGithub(pageNumber:Int):Call<List<ShowPrListResponse>>
}