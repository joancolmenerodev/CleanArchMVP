package com.joancolmenerodev.feature.coindetail.mapper

import com.joancolmenerodev.entities.CryptoDetail
import com.joancolmenerodev.entities.CryptoDetailResponse
import com.joancolmenerodev.entities.Status
import com.joancolmenerodev.entities.Urls
import com.joancolmenerodev.features.coindetail.models.CoinDetail
import org.junit.Assert
import org.junit.Test

class CryptoDetailCurrencyMapperTest {

    @Test
    fun `cryptoDetailCurrency mapper test`() {

        //ASSIGN
        val expectedResult = CoinDetail(
            logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/6.png",
            name = "Novacoin",
            symbol = "NVC",
            description = "Novacoin (NVC) is a cryptocurrency. Users are able to generate NVC through the process of mining. Novacoin has a current supply of 2,335,756.714. The last known price of Novacoin is $0.286649 USD and is down -11.00% over the last 24 hours. It is currently trading on 2 active market(s) with $712.86 traded over the last 24 hours. More information can be found at http://novacoin.org.",
            website = "http://novacoin.org"
        )

        //ACT
        val result = cryptoDetailResponse.map()

        //ASSERT
        Assert.assertEquals(expectedResult, result)

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