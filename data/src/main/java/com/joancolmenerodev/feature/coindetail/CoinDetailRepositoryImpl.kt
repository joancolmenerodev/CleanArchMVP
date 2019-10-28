package com.joancolmenerodev.feature.coindetail

import com.joancolmenerodev.AbstractRetrofitApi
import com.joancolmenerodev.service.CryptoCurrencyService

class CoinDetailRepositoryImpl(private val api: CryptoCurrencyService) : CryptoCurrencyRepository ,AbstractRetrofitApi() {
}