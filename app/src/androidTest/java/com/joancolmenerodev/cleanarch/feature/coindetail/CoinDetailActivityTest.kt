package com.joancolmenerodev.cleanarch.feature.coindetail

import android.content.Intent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.SmallTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.joancolmenerodev.cleanarch.base.BaseTest
import com.joancolmenerodev.cleanarch.feature.coindetail.page.CoinDetailPage
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CoinDetailActivityTest : BaseTest<CoinDetailActivity>() {
    override fun getTestActivity() = IntentsTestRule(CoinDetailActivity::class.java, true, false)

    private val cryptoDetailPage = CoinDetailPage(context)

    @Before
    override fun setUp() {
        super.setUp()
        launchActivity(Intent().putExtra(EXTRA_KEY, CRYPTO_ID))
    }

    @Test
    @SmallTest
    fun loadDataSuccessfully() {
        at(cryptoDetailPage)

        cryptoDetailPage.cryptoNameText(CRYPTO_NAME)

    }

    companion object {
        const val CRYPTO_NAME = "Bitcoin"
        const val CRYPTO_ID = 1
        const val EXTRA_KEY = "COIN_ID"
    }
}