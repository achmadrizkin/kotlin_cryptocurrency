package com.example.cyptocurrencyapp.data.repository

import com.example.cyptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cyptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cyptocurrencyapp.data.remote.dto.CoinDto
import com.example.cyptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoin()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}