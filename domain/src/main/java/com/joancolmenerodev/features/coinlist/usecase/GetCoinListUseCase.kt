package com.joancolmenerodev.cleanarch.feature.coinlist.usecase

import com.joancolmenerodev.features.coinlist.repository.CoinListRepository

open class GetCoinListUseCase(private val cryptoRepository: CoinListRepository) {
    open suspend fun execute() = cryptoRepository.getCoinList()
}