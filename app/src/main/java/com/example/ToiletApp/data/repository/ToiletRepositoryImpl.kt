package com.example.ToiletApp.data.repository

import com.example.ToiletApp.common.APIResponse
import com.example.ToiletApp.data.data_resource.ToiletDataResource
import com.example.ToiletApp.network.toilet.response.FetchToiletResponse

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToiletRepositoryImpl @Inject constructor(
    private val toiletDataResource: ToiletDataResource
) : ToiletRepository {
    override suspend fun readToilet(): APIResponse<FetchToiletResponse> {

        // toilet 생성 요청이 성공하면 Success에 데이터를, 실패하면 Error에 message 리턴
        val response = toiletDataResource.readToilet().clone().execute()
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return APIResponse.Success(result)
            }
        }
        return APIResponse.Error(response.message())
    }
}