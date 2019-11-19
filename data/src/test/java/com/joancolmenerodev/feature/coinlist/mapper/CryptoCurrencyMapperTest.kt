package com.joancolmenerodev.feature.coinlist.mapper

import com.joancolmenerodev.entities.CryptoResponse
import com.joancolmenerodev.entities.Data
import com.joancolmenerodev.entities.Status
import com.joancolmenerodev.features.coinlist.models.CoinList
import org.junit.Assert
import org.junit.Test

class CryptoCurrencyMapperTest {

    @Test
    fun `cryptoCurrency mapper test`() {

        //ASSIGN
        val expectedResult = listOf(
            CoinList(1, "Bitcoin", "BTC"),
            CoinList(2, "Litecoin", "LTC")
        )

        //ACT
        val result = cryptoResponse.map()


        //ASSERT
        Assert.assertEquals(expectedResult,result)

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