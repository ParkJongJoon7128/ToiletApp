package com.example.ToiletApp.data.data_resource

import com.example.ToiletApp.network.toilet.response.FetchToiletResponse
import retrofit2.Call

interface ToiletDataResource {
    suspend fun readToilet(): Call<FetchToiletResponse>

}