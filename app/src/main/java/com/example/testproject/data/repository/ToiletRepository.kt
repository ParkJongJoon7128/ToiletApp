package com.example.testproject.data.repository

import com.example.testproject.common.APIResponse
import com.example.testproject.network.toilet.response.FetchToiletResponse

interface ToiletRepository {
    suspend fun readToilet(): APIResponse<FetchToiletResponse>
}