package com.joancolmenerodev.features.coinlist.repository

import com.joancolmenerodev.ResultWrapper


interface CoinListRepository {

    suspend fun getCoinList(): ResultWrapper<List<CoinList>>
}