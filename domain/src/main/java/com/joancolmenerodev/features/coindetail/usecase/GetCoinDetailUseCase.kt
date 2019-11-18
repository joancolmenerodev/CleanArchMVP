package com.joancolmenerodev.features.coindetail.usecase

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.features.coindetail.models.CoinDetail
import com.joancolmenerodev.features.coindetail.repository.CoinDetailRepository

open class GetCoinDetailUseCase(private val cryptoRepository: CoinDetailRepository) {
    open suspend fun execute(cryptoId: Int?): ResultWrapper<CoinDetail> {
        val id = cryptoId ?: -1
        return cryptoRepository.getCoinDetail(cryptoId = id)
    }
}