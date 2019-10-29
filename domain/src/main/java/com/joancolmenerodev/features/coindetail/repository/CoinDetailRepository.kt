package com.joancolmenerodev.features.coindetail.repository

import com.joancolmenerodev.model.CryptoDetailResponse

interface CoinDetailRepository {

    suspend fun getCoinDetail(cryptoId: Int): CryptoDetailResponse
}