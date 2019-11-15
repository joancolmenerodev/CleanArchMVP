package com.joancolmenerodev.feature.coindetail.mapper

import com.joancolmenerodev.entities.CryptoDetailResponse
import com.joancolmenerodev.features.coindetail.models.CoinDetail

fun CryptoDetailResponse.map(): CoinDetail {
    val coin = this.data.values.first()
    return CoinDetail(coin.logo, coin.name, coin.symbol, coin.description, coin.urls.website.first())

}