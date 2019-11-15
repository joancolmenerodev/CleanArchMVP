package com.joancolmenerodev.features.coinlist.repository

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.features.coinlist.models.CoinList


interface CoinListRepository {

    suspend fun getCoinList(): ResultWrapper<List<CoinList>>
}