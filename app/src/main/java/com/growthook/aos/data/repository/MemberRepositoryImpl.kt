package com.growthook.aos.data.repository

import com.growthook.aos.data.service.MemberService
import com.growthook.aos.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(private val apiService: MemberService) :
    MemberRepository {
    override suspend fun getGatherdThook(memberId: Int): Result<Int> = runCatching {
        apiService.getGatheredThook(memberId).data.gatheredThook
    }
}