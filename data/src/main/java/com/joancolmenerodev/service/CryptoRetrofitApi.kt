package com.joancolmenerodev.service

import com.joancolmenerodev.AbstractRetrofitApi

class CryptoRetrofitApi(private val service: CryptoCurrencyService) : AbstractRetrofitApi(), CryptoCurrencyApi {
    override suspend fun getCryptoCurrency() = execute {
        service.getCryptoCurrency()

    }

    override suspend fun getCryptoInfo(cryptoInfo: Int) = execute {
        service.getCryptoInfo(cryptoInfo)
    }
}