package com.joancolmenerodev.features.coindetail.repository

import com.joancolmenerodev.features.coindetail.model.CryptoDetailResponse

interface CryptoCurrencyRepository {

    suspend fun getCoinList(): ResultWrapper<CryptoResponse>
    suspend fun getCoinDetail(cryptoId: Int): ResultWrapper<CryptoDetailResponse>
}