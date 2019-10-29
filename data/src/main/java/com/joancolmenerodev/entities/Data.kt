package com.joancolmenerodev.entities

data class Data(
    val first_historical_data: String,
    val id: Int,
    val is_active: Int,
    val last_historical_data: String,
    val name: String,
    val platform: Any,
    val slug: String,
    val symbol: String
)