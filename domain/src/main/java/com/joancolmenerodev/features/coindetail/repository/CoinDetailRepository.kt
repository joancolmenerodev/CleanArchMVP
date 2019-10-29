package com.joancolmenerodev.features.coindetail.repository

import com.joancolmenerodev.features.coindetail.model.CryptoDetailResponse

interface CoinDetailRepository {

    suspend fun getCoinDetail(cryptoId: Int): ResultWrapper<CryptoDetailResponse>
}