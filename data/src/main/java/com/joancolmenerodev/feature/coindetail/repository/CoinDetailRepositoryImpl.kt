package com.joancolmenerodev.feature.coindetail.repository

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.feature.coindetail.mapper.map
import com.joancolmenerodev.features.coindetail.models.CoinDetail
import com.joancolmenerodev.features.coindetail.repository.CoinDetailRepository
import com.joancolmenerodev.service.CryptoCurrencyApi

class CoinDetailRepositoryImpl(private val api: CryptoCurrencyApi) : CoinDetailRepository {
    override suspend fun getCoinDetail(cryptoId: Int): ResultWrapper<CoinDetail> =
        api.getCryptoInfo(cryptoInfo = cryptoId).fold({
            ResultWrapper.Failure(it)
        }, {
            ResultWrapper.Success(it.map())
        })
}