package com.joancolmenerodev.cleanarch.feature.coinlist

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.SmallTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.joancolmenerodev.cleanarch.base.BaseTest
import com.joancolmenerodev.cleanarch.feature.coindetail.page.CoinDetailPage
import com.joancolmenerodev.cleanarch.feature.coinlist.page.CoinListPage
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CoinListActivityTest : BaseTest<MainActivity>() {
    override fun getTestActivity() = IntentsTestRule(MainActivity::class.java, true, false)

    private val mainActivityPage = CoinListPage(context)
    private val cryptoDetailPage = CoinDetailPage(context)

    @Before
    override fun setUp() {
        super.setUp()
        launchActivity(null)
    }

    @Test
    @SmallTest
    fun loadDataSuccessfully(){
        Thread.sleep(5000)
        at(mainActivityPage)
        mainActivityPage.isRecyclerViewFilled()
        at(cryptoDetailPage)
    }
}