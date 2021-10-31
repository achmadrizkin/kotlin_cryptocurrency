package com.example.cyptocurrencyapp.domain.use_case.get_coins

import com.example.cyptocurrencyapp.common.Resource
import com.example.cyptocurrencyapp.data.remote.dto.toCoin
import com.example.cyptocurrencyapp.data.remote.dto.toCointDetail
import com.example.cyptocurrencyapp.domain.model.Coin
import com.example.cyptocurrencyapp.domain.model.CoinDetail
import com.example.cyptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    // override invoke -> want to emit multiple value (flow) -> service Handle -> return List<Coin>
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }

            emit(Resource.Success<List<Coin>>(coins))

        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexcepted error occured"))
        } catch (e: IOException) {
            // use for no internet connection ( no error from server / server is offline )
            emit(Resource.Error<List<Coin>>("Coulnd't reach server. Check your internet connection"))
        }
    }
}