package com.example.cyptocurrencyapp.presentasion.coin_details

import com.example.cyptocurrencyapp.domain.model.Coin
import com.example.cyptocurrencyapp.domain.model.CoinDetail

data class CoinDetailsListState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
