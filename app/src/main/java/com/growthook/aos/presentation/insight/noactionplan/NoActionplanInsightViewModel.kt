package com.growthook.aos.presentation.insight.noactionplan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.growthook.aos.domain.entity.Cave
import com.growthook.aos.domain.entity.Seed
import com.growthook.aos.domain.usecase.GetCavesUseCase
import com.growthook.aos.domain.usecase.local.GetUserUseCase
import com.growthook.aos.domain.usecase.seeddetail.GetSeedUseCase
import com.growthook.aos.presentation.insight.actionplan.ActionplanInsightViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NoActionplanInsightViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getSeedUseCase: GetSeedUseCase,
    private val getCavesUseCase: GetCavesUseCase,
) :
    ViewModel() {
    private val _caves = MutableLiveData<List<Cave>>()
    val caves: LiveData<List<Cave>> = _caves

    private val _seedData = MutableLiveData<Seed>()
    val seedData: LiveData<Seed> = _seedData

    private val _event = MutableLiveData<ActionplanInsightViewModel.Event>()
    val event: LiveData<ActionplanInsightViewModel.Event> = _event

    init {
        getSeedDetail(47)
        // TODO seedId 변경하기
    }

    private fun getSeedDetail(seedId: Int) {
        viewModelScope.launch {
            getSeedUseCase.invoke(seedId)
                .onSuccess { seed ->
                    Log.d("seed", "seed:: $seed")
                    _seedData.value = seed
                    _event.value = ActionplanInsightViewModel.Event.Success
                }
                .onFailure { throwable ->
                    Timber.e(throwable.message)
                    _event.value = ActionplanInsightViewModel.Event.Failed
                }
        }
    }

    fun getCaves() {
        viewModelScope.launch {
//            getCavesUseCase(getUserUseCase.invoke().memberId ?: 0).onSuccess { caves ->
            /*
            임시로 memberId 3으로 넣음 (확인용)
             */
            Log.d("user", "memberID:: ${getUserUseCase.invoke().memberId}")
            getCavesUseCase(3).onSuccess { caves ->
                _caves.value = caves
            }
        }
    }
}
