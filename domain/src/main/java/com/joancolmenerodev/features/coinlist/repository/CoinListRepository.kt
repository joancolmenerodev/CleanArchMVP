package com.joancolmenerodev.features.coinlist.repository

import com.joancolmenerodev.model.CryptoResponse

interface CoinListRepository {

    suspend fun getCoinList(): CryptoResponse
}