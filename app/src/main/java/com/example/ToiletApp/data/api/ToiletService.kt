package com.example.ToiletApp.data.api

import com.example.ToiletApp.network.toilet.response.FetchToiletResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ToiletService {

    @GET("/Publtolt/")
    fun requestToilet(
        @Query("Key") key: String,
        @Query("Type") type: String = "json",
        @Query("pIndex") pageIndex: Int = 1,
        @Query("pSize") pageSize: Int = 1000
    ): Call<FetchToiletResponse>
}