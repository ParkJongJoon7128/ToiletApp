package com.example.testproject.data.data_resource

import com.example.testproject.network.toilet.response.FetchToiletResponse
import retrofit2.Call

interface ToiletDataResource {
    suspend fun readToilet(): Call<FetchToiletResponse>

}