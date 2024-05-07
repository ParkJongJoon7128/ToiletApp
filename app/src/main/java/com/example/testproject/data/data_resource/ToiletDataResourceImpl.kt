package com.example.testproject.data.data_resource

import com.example.testproject.data.api.ToiletService
import com.example.testproject.network.toilet.response.FetchToiletResponse
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToiletDataResourceImpl @Inject constructor(
    private val toiletService: ToiletService
) : ToiletDataResource {
    override suspend fun readToilet(): Call<FetchToiletResponse> {
        return toiletService.requestToilet()
    }
}