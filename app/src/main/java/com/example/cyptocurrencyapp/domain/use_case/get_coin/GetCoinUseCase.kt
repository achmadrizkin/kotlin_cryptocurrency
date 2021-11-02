package com.example.cyptocurrencyapp.domain.use_case.get_coin

import com.example.cyptocurrencyapp.common.Resource
import com.example.cyptocurrencyapp.data.remote.dto.toCointDetail
import com.example.cyptocurrencyapp.domain.model.CoinDetail
import com.example.cyptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    // override invoke -> want to emit multiple value (flow) -> service Handle -> return List<Coin>
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCointDetail()

            emit(Resource.Success<CoinDetail>(coin))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexcepted error occured"))
        } catch (e: IOException) {
            // use for no internet connection ( no error from server / server is offline )
            emit(Resource.Error<CoinDetail>("Coulnd't reach server. Check your internet connection"))
        }
    }
}