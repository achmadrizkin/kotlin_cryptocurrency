package com.example.cyptocurrencyapp.presentasion.coin_list

import com.example.cyptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
