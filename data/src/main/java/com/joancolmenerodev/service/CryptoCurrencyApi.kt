package com.joancolmenerodev.service

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.entities.CryptoDetailResponse
import com.joancolmenerodev.entities.CryptoResponse

interface CryptoCurrencyApi {

    suspend fun getCryptoCurrency(): ResultWrapper<CryptoResponse>
    suspend fun getCryptoInfo(cryptoInfo: Int): ResultWrapper<CryptoDetailResponse>
}