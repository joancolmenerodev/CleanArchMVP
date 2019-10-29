package com.joancolmenerodev.service

import com.joancolmenerodev.entities.CryptoDetailResponse
import com.joancolmenerodev.entities.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCurrencyService {

    @GET("v1/cryptocurrency/map?limit=50")
    suspend fun getCryptoCurrency(): CryptoResponse

    @GET("v1/cryptocurrency/info")
    suspend fun getCryptoInfo(@Query("id") id: Int): CryptoDetailResponse
}