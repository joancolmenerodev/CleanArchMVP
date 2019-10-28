package com.joancolmenerodev.features.coindetail.model

data class CryptoDetailResponse(
    val data: Map<String, CryptoDetail>,
    val status: Status
)