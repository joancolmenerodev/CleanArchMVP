package com.joancolmenerodev.feature.coinlist

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.feature.coinlist.mapper.map
import com.joancolmenerodev.features.coinlist.models.CoinList
import com.joancolmenerodev.features.coinlist.repository.CoinListRepository
import com.joancolmenerodev.service.CryptoCurrencyApi

open class CoinListRepositoryImpl(private val api: CryptoCurrencyApi) : CoinListRepository {

    override suspend fun getCoinList(): ResultWrapper<List<CoinList>> =
        api.getCryptoCurrency().fold({
            ResultWrapper.Failure(it)
        }, {
            ResultWrapper.Success(it.map())
        })
}
