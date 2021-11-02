package com.example.cyptocurrencyapp.presentasion.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cyptocurrencyapp.common.Constant
import com.example.cyptocurrencyapp.common.Resource
import com.example.cyptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle //navigation parameter

) : ViewModel() {
    // maintain state
    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_COIN_ID)?.let { coinId -> getCoin(coinId) }
    }

    // get data -> display ui (async)
    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach {
            result -> when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}