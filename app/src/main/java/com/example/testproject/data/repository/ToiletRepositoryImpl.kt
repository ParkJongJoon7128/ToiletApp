package com.example.testproject.data.repository

import com.example.testproject.common.APIResponse
import com.example.testproject.data.data_resource.ToiletDataResource
import com.example.testproject.network.toilet.response.FetchToiletResponse
import org.openjdk.tools.javac.util.DefinedBy.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToiletRepositoryImpl @Inject constructor(
    private val ToiletDataResource: ToiletDataResource
) : ToiletRepository {
    override suspend fun readToilet(): APIResponse<FetchToiletResponse> {

        // toilet 생성 요청이 성공하면 Success에 데이터를, 실패하면 Error에 message 리턴
        val response = ToiletDataResource.readToilet().clone().execute()
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return APIResponse.Success(result)
            }
        }
        return APIResponse.Error(response.message())
    }
}