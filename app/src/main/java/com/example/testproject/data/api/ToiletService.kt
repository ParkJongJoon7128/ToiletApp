package com.example.testproject.data.api

import com.example.testproject.network.toilet.response.FetchToiletResponse
import retrofit2.Call
import retrofit2.http.GET

interface ToiletService {

    @GET("/")
    fun requestToilet(): Call<FetchToiletResponse>
}