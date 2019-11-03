package com.joancolmenerodev.features.coindetail.repository

import com.joancolmenerodev.ResultWrapper

interface CoinDetailRepository {

    suspend fun getCoinDetail(cryptoId: Int): ResultWrapper<CoinDetail>

}