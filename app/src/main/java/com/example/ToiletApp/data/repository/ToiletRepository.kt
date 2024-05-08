package com.example.ToiletApp.data.repository

import com.example.ToiletApp.common.APIResponse
import com.example.ToiletApp.network.toilet.response.FetchToiletResponse

interface ToiletRepository {
    suspend fun readToilet(): APIResponse<FetchToiletResponse>
}