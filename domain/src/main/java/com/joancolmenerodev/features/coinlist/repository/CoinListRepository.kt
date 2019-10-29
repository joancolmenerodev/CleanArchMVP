package com.joancolmenerodev.features.coinlist.repository

interface CoinListRepository {

    suspend fun getCoinList(): ResultWrapper<CryptoResponse>
}