package com.example.showprrequests.showPrRequest.domain

import com.example.showprrequests.showPrRequest.data.ShowPrListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.security.acl.Owner

interface ShowPrListService {
    @GET("/repos/android/architecture-samples/pulls?state=closed")
    fun getPrList(@Query("page") page:Int,@Query("per_page") perPage:Int = 10):Call<List<ShowPrListResponse>>
}