package com.joancolmenerodev.feature.coinlist.mapper

import com.joancolmenerodev.entities.CryptoResponse


fun CryptoResponse.map() = this.data.map { CoinList(it.id,it.name,it.symbol) }