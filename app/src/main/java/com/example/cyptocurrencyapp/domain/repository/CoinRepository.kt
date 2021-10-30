package com.example.cyptocurrencyapp.domain.repository

import com.example.cyptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cyptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    // using for test

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}