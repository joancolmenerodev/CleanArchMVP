package com.joancolmenerodev.service

interface CryptoCurrencyService {

    @GET("v1/cryptocurrency/map?limit=50")
    suspend fun getCryptoCurrency(): CryptoResponse

    @GET("v1/cryptocurrency/info")
    suspend fun getCryptoInfo(@Query("id") id: Int): CryptoDetailResponse
}