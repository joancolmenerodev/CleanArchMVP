package com.joancolmenerodev.features.coindetail.usecase

import com.joancolmenerodev.features.coindetail.repository.CoinDetailRepository

open class GetCoinDetailUseCase(private val cryptoRepository: CoinDetailRepository) {
    open suspend fun execute(cryptoId: Int) = cryptoRepository.getCoinDetail(cryptoId = cryptoId)
}