package com.growthook.aos.data.service

import com.growthook.aos.data.model.response.BaseResponse
import com.growthook.aos.data.model.response.ResponseGetCavesDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface CaveService {

    @DELETE("api/v1/cave/{caveId}")
    suspend fun deleteCave(
        @Path("caveId") caveId: Int,
    ): BaseResponse<Unit>

    @GET("api/v1/member/{memberId}/cave/all")
    suspend fun getCaves(
        @Path("memberId") memberId: Int,
    ): BaseResponse<List<ResponseGetCavesDto>>
}