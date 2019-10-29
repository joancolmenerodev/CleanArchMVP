package com.joancolmenerodev.model

data class CryptoDetailResponse(
    val data: Map<String, CryptoDetail>,
    val status: Status
)