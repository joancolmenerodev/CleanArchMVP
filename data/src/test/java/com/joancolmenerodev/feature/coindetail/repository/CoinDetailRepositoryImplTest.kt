package com.joancolmenerodev.feature.coindetail.repository

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.entities.CryptoDetail
import com.joancolmenerodev.entities.CryptoDetailResponse
import com.joancolmenerodev.entities.Status
import com.joancolmenerodev.entities.Urls
import com.joancolmenerodev.failureOrNull
import com.joancolmenerodev.features.coindetail.models.CoinDetail
import com.joancolmenerodev.features.coindetail.repository.CoinDetailRepository
import com.joancolmenerodev.getOrDefault
import com.joancolmenerodev.service.CryptoCurrencyApi
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CoinDetailRepositoryImplTest {

    private lateinit var coinDetailRepository: CoinDetailRepository

    private val mockApi: CryptoCurrencyApi = mock()

    @Before
    fun setUp() {
        coinDetailRepository = CoinDetailRepositoryImpl(mockApi)
    }

    @Test
    fun `given the repository returns a coin detail`() {

        //ASSIGN
        val expectedResult = CoinDetail(
            logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/6.png",
            name = "Novacoin",
            symbol = "NVC",
            description = "Novacoin (NVC) is a cryptocurrency. Users are able to generate NVC through the process of mining. Novacoin has a current supply of 2,335,756.714. The last known price of Novacoin is $0.286649 USD and is down -11.00% over the last 24 hours. It is currently trading on 2 active market(s) with $712.86 traded over the last 24 hours. More information can be found at http://novacoin.org.",
            website = "http://novacoin.org"
        )
        runBlocking {
            whenever(mockApi.getCryptoInfo(1)).thenReturn(ResultWrapper.Success(cryptoDetailResponse))
        }

        //ACT
        val result = runBlocking {
            coinDetailRepository.getCoinDetail(1)
        }

        //ASSERT
        Assert.assertEquals(expectedResult,result.getOrDefault { null })

    }

    @Test
    fun `given the repository returns a failure`() {

        //ASSIGN
        val expectedResult = Throwable("Something wrong happened")
        runBlocking {
            whenever(mockApi.getCryptoInfo(1)).thenReturn(ResultWrapper.Failure(expectedResult))
        }

        //ACT
        val result = runBlocking {
            coinDetailRepository.getCoinDetail(1)
        }

        //ASSERT
        Assert.assertEquals(expectedResult,result.failureOrNull())
    }

    companion object {
        val cryptoDetailResponse = CryptoDetailResponse(
            data = mapOf(
                "1" to CryptoDetail(
                    category = "coin",
                    date_added = "2013-04-28T00:00:00.000Z",
                    description = "Novacoin (NVC) is a cryptocurrency. Users are able to generate NVC through the process of mining. Novacoin has a current supply of 2,335,756.714. The last known price of Novacoin is $0.286649 USD and is down -11.00% over the last 24 hours. It is currently trading on 2 active market(s) with $712.86 traded over the last 24 hours. More information can be found at http://novacoin.org.",
                    id = 6,
                    logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/6.png",
                    name = "Novacoin",
                    platform = "null",
                    slug = "novacoin",
                    symbol = "NVC",
                    tags = listOf<String>("mineable"),
                    urls = Urls(
                        announcement = listOf(
                            "https://bitcointalk.org/index.php?topic=143221.0"
                        ),
                        chat = listOf<String>(),
                        explorer = listOf<String>("https://explorer.novaco.in/"),
                        message_board = emptyList<String>(),
                        reddit = listOf<String>("https://reddit.com/r/Novacoin"),
                        source_code = listOf<String>("https://github.com/novacoin-project/novacoin"),
                        twitter = emptyList<String>(),
                        website = listOf<String>("http://novacoin.org")
                    )
                )
            )
            ,
            status = Status(
                credit_count = 1,
                elapsed = 15,
                error_code = 0,
                error_message = "pew",
                timestamp = "2019-11-19T14:44:11.576Z"
            )
        )
    }
}