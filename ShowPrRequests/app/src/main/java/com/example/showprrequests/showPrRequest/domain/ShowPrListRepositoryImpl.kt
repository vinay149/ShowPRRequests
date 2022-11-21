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

    override suspend fun getPrListFromGithub(pageNumber: Int ):Call<List<ShowPrListResponse>>{
        return showPrListService.getPrList(pageNumber)
    }
}