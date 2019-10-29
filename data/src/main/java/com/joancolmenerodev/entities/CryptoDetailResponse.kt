package com.joancolmenerodev.entities

import com.joancolmenerodev.model.CryptoDetail

data class CryptoDetailResponse(
    val data: Map<String, CryptoDetail>,
    val status: Status
)