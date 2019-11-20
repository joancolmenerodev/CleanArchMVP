package com.joancolmenerodev.feature.coinlist.repository

import com.joancolmenerodev.IntegrationTest
import com.joancolmenerodev.entities.CryptoResponse
import com.joancolmenerodev.entities.Data
import com.joancolmenerodev.entities.Status
import com.joancolmenerodev.getOrDefault
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.net.HttpURLConnection

//How to put this in a different folder like Integration, so we can differenciate Unitary test and Integration ones
class CoinListRepositoryIntegrationTest : IntegrationTest() {

    @Test
    fun `given that the coin list is called then it returns success`() {
        // ASSIGN
        val expectedResult = cryptoResponse
        mockHttpResponse("coin_list_response.json", HttpURLConnection.HTTP_OK)

        val response = runBlocking {
            // ACT
            cryptoRetrofitApi.getCryptoCurrency()
        }

        // ASSERT
        assertEquals(expectedResult.toString(), response.getOrDefault { null }.toString())
    }

    @Test
    fun `given that the detail coin is called then it returns failure`() {
        // ASSIGN
        mockHttpResponse("coin_list_response.json", HttpURLConnection.HTTP_INTERNAL_ERROR)

        val response = runBlocking {
            // ACT
            cryptoRetrofitApi.getCryptoCurrency()
        }

        // ASSERT
        assertTrue(response.isFailure())
    }


    companion object {
        val cryptoResponse = CryptoResponse(
            data = listOf(
                Data(
                    first_historical_data = "2013-04-28T18:47:21.000Z",
                    id = 1,
                    is_active = 1,
                    last_historical_data = "2019-11-20T14:09:00.000Z",
                    name = "Bitcoin",
                    platform = "null",
                    slug = "bitcoin",
                    symbol = "BTC"
                ),
                Data(
                    first_historical_data = "2013-04-28T18:47:22.000Z",
                    id = 2,
                    is_active = 1,
                    last_historical_data = "2019-11-20T14:09:00.000Z",
                    name = "Litecoin",
                    platform = "null",
                    slug = "litecoin",
                    symbol = "LTC"
                )
            ),
            status = Status(
                credit_count = 1,
                elapsed = 15,
                error_code = 0,
                error_message = "null",
                timestamp = "2019-11-20T14:10:48.012Z"
            )
        )
    }
}