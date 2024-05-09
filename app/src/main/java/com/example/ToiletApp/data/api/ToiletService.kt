package com.example.ToiletApp.data.api

import com.example.ToiletApp.network.toilet.response.FetchToiletResponse
import retrofit2.Call
import retrofit2.http.GET

interface ToiletService {

    @GET("/Publtolt/")
    fun requestToilet(): Call<FetchToiletResponse>
}