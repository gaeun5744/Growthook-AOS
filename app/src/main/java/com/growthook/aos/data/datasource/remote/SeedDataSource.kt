package com.growthook.aos.data.datasource.remote

import com.growthook.aos.data.model.request.RequestSeedMoveDto
import com.growthook.aos.data.model.request.RequestSeedPostDto
import com.growthook.aos.data.model.response.ResponseAlarmDto
import com.growthook.aos.data.model.response.ResponseDto
import com.growthook.aos.data.model.response.ResponseGetCaveSeedsDto
import com.growthook.aos.data.model.response.ResponseGetSeedDto
import com.growthook.aos.data.model.response.ResponseGetSeedsDto
import com.growthook.aos.data.model.response.ResponseMoveSeedDto
import com.growthook.aos.data.model.response.ResponsePostSeedDto

interface SeedDataSource {

    suspend fun getSeed(seedId: Int): ResponseGetSeedDto
    suspend fun deleteSeed(seedId: Int): ResponseDto

    suspend fun moveSeed(seedId: Int, request: RequestSeedMoveDto): ResponseMoveSeedDto

    suspend fun postSeed(caveId: Int, request: RequestSeedPostDto): ResponsePostSeedDto

    suspend fun getCaveSeeds(caveId: Int): ResponseGetCaveSeedsDto

    suspend fun getSeedAlarm(memberId: Int): ResponseAlarmDto

    suspend fun getSeeds(memberId: Int): ResponseGetSeedsDto
}
