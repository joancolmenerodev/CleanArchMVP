package com.joancolmenerodev.entities

data class CryptoDetailResponse(
    val data: Map<String, CryptoDetail>,
    val status: Status
)