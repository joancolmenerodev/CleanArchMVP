package com.joancolmenerodev.feature.coindetail.repository

import com.joancolmenerodev.AbstractRetrofitApi
import com.joancolmenerodev.features.coindetail.repository.CoinDetailRepository
import com.joancolmenerodev.service.CryptoCurrencyService

class CoinDetailRepositoryImpl(private val api: CryptoCurrencyService) : CoinDetailRepository,AbstractRetrofitApi() {
}