package com.joancolmenerodev.feature.coindetail.repository

import com.joancolmenerodev.IntegrationTest
import com.joancolmenerodev.entities.CryptoDetail
import com.joancolmenerodev.entities.CryptoDetailResponse
import com.joancolmenerodev.entities.Status
import com.joancolmenerodev.entities.Urls
import com.joancolmenerodev.failureOrNull
import com.joancolmenerodev.getOrDefault
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.net.HttpURLConnection

//How to put this in a different folder like Integration, so we can differenciate Unitary test and Integration ones
class CoinDetailRepositoryIntegrationTest : IntegrationTest() {

    @Test
    fun `given that the detail coin is called then it returns success`() {
        // ASSIGN
        val expectedResult = cryptoDetailResponse
        mockHttpResponse("coin_detail_response.json", HttpURLConnection.HTTP_OK)

        val response = runBlocking {
            // ACT
            cryptoRetrofitApi.getCryptoInfo(2)
        }

        // ASSERT
        assertEquals(expectedResult.toString(), response.getOrDefault { null }.toString())
    }

    @Test
    fun `given that the detail coin is called then it returns failure`() {
        // ASSIGN
        mockHttpResponse("coin_detail_response.json", HttpURLConnection.HTTP_INTERNAL_ERROR)

        val response = runBlocking {
            // ACT
            cryptoRetrofitApi.getCryptoInfo(2)
        }

        // ASSERT
        assertTrue(response.isFailure())
    }




    companion object {
        val cryptoDetailResponse = CryptoDetailResponse(
            data = mapOf(
                "2" to CryptoDetail(
                    category = "coin",
                    date_added = "2013-04-28T00:00:00.000Z",
                    description = "Litecoin is a peer-to-peer cryptocurrency created by Charlie Lee. It was created based on the Bitcoin protocol but differs in terms of the hashing algorithm used. Litecoin uses the memory intensive Scrypt proof of work mining algorithm. Scrypt allows consumer-grade hardware such as GPU to mine those coins.",
                    id = 2,
                    logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/2.png",
                    name = "Litecoin",
                    platform = "null",
                    slug = "litecoin",
                    symbol = "LTC",
                    tags = listOf<String>("mineable"),
                    urls = Urls(
                        announcement = listOf(
                            "https://bitcointalk.org/index.php?topic=47417.0"
                        ),
                        chat = listOf<String>("https://telegram.me/litecoin"),
                        explorer = listOf<String>(
                            "https://blockchair.com/litecoin",
                            "https://chainz.cryptoid.info/ltc/",
                            "http://explorer.litecoin.net/chain/Litecoin",
                            "https://ltc.tokenview.com/en",
                            "https://explorer.viabtc.com/ltc"
                        ),
                        message_board = listOf<String>(
                            "https://litecointalk.io/",
                            "https://litecoin-foundation.org/"
                        ),
                        reddit = listOf<String>("https://reddit.com/r/litecoin"),
                        source_code = listOf<String>("https://github.com/litecoin-project/litecoin"),
                        twitter = listOf<String>("https://twitter.com/LitecoinProject"),
                        website = listOf<String>("https://litecoin.org/")
                    )
                )
            )
            ,
            status = Status(
                credit_count = 1,
                elapsed = 8,
                error_code = 0,
                error_message = "null",
                timestamp = "2019-11-20T14:12:25.772Z"
            )
        )
    }
}