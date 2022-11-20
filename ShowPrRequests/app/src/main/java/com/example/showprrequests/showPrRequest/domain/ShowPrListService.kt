package com.example.showprrequests.showPrRequest.domain

import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.security.acl.Owner

interface ShowPrListService {
    @GET("/repos/vinay149/ShowPRRequests/pulls ")
    fun getPrList():Call<List<ShowPrListResponse>>
}