package com.joancolmenerodev.feature.coinlist.repository

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.entities.CryptoResponse
import com.joancolmenerodev.entities.Data
import com.joancolmenerodev.entities.Status
import com.joancolmenerodev.failureOrNull
import com.joancolmenerodev.feature.coinlist.CoinListRepositoryImpl
import com.joancolmenerodev.features.coinlist.models.CoinList
import com.joancolmenerodev.features.coinlist.repository.CoinListRepository
import com.joancolmenerodev.getOrDefault
import com.joancolmenerodev.service.CryptoCurrencyApi
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CoinListRepositoryImplTest {

    private lateinit var coinListRepository: CoinListRepository

    private val mockApi: CryptoCurrencyApi = mock()

    @Before
    fun setUp() {
        coinListRepository = CoinListRepositoryImpl(mockApi)
    }

    @Test
    fun `given the repository returns a coin list`() {

        //ASSIGN
        val expectedResult = listOf(
            CoinList(1, "Bitcoin", "BTC"),
            CoinList(2, "Litecoin", "LTC")
        )
        runBlocking {
            whenever(mockApi.getCryptoCurrency()).thenReturn(ResultWrapper.just(cryptoResponse))
        }

        //ACT
        val result = runBlocking {
            coinListRepository.getCoinList()
        }

        //ASSERT
        Assert.assertEquals(expectedResult,result.getOrDefault { null })
    }

    @Test
    fun `given the repository returns a failure`() {

        //ASSIGN
        val expectedResult = Throwable("Something wrong happened")
        runBlocking {
            whenever(mockApi.getCryptoCurrency()).thenReturn(ResultWrapper.Failure(expectedResult))
        }

        //ACT
        val result = runBlocking {
            coinListRepository.getCoinList()
        }

        //ASSERT
        Assert.assertEquals(expectedResult,result.failureOrNull())
    }

    companion object {
        val cryptoResponse = CryptoResponse(
            data = listOf(
                Data(
                    first_historical_data = "2013-04-28T18:47:21.000Z",
                    id = 1,
                    is_active = 1,
                    last_historical_data = "2019-11-19T14:29:01.000Z",
                    name = "Bitcoin",
                    platform = "wut",
                    slug = "bitcoin",
                    symbol = "BTC"
                ),
                Data(
                    first_historical_data = "2013-04-28T18:47:22.000Z",
                    id = 2,
                    is_active = 1,
                    last_historical_data = "2019-11-19T14:29:01.000Z",
                    name = "Litecoin",
                    platform = "wut",
                    slug = "litecoin",
                    symbol = "LTC"
                )
            ),
            status = Status(
                credit_count = 1,
                elapsed = 1,
                error_code = 1,
                error_message = "pew",
                timestamp = "2013-04-28T18:47:22.000Z"
            )
        )
    }
}