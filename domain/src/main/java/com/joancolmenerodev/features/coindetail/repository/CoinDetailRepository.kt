package com.joancolmenerodev.features.coindetail.repository

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.features.coindetail.models.CoinDetail

interface CoinDetailRepository {

    suspend fun getCoinDetail(cryptoId: Int): ResultWrapper<CoinDetail>

}